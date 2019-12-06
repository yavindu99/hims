package hims.admical.clinic.cl_data_element;

import hims.common.ClientMessages;
import hims.common.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

@Repository
@Transactional
public class ClDataElementDAOImpl implements ClDataElementDAOInt {

    private ClDataElementRepositoryInt repo;

    @Autowired
    public ClDataElementDAOImpl(ClDataElementRepositoryInt repo) {
        this.repo = repo;
    }

    @Override
    public ClDataElement add(ClDataElement clDataElement) throws CustomException {

        ClDataElement clDataElementByUid = repo.findClDataElementByUid(clDataElement.getUid());

        if (Objects.nonNull(clDataElementByUid)) {

            throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "duplicate_entry_data_element_uid_cannot_be_duplicated");

        }

        return repo.save(clDataElement);

    }

    @Override
    public List<ClDataElement> addList(List<ClDataElement> clDataElementList) throws CustomException {

        Iterator<ClDataElement> it = clDataElementList.iterator();
        while (it.hasNext()){

            ClDataElement clDataElement = it.next();
            String uid = clDataElement.getUid();

            ClDataElement clDataElementByUid = repo.findClDataElementByUid(uid);

            if (Objects.nonNull(clDataElementByUid)) {

                throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "duplicate_entry_data_element_uid_cannot_be_duplicated");

            }

        }

        return repo.saveAll(clDataElementList);

    }

    @Override
    public ClDataElement assignChildElementList(ClDataElement clDataElement) throws CustomException {

        int parentDataElementId = clDataElement.getDataElementId();

        List<ClDataElement> clDataElementList = clDataElement.getClChildDataElementList();

        Iterator<ClDataElement> it = clDataElementList.iterator();

        while (it.hasNext()){

            ClDataElement childDataElement = it.next();

            int childDataElementId = childDataElement.getDataElementId();

            repo.assignChildElementList(parentDataElementId,childDataElementId);

        }

        return this.getByDataElementId(parentDataElementId);

    }

    @Override
    public ClDataElement assignCategories(ClDataElement clDataElement) throws CustomException {

        Set<ClDataElement> clDataElementCategorySet = clDataElement.getClDataElementCategorySet();
        int dataElementId = clDataElement.getDataElementId();
        ClDataElement existingDataElement  = repo.findById(dataElementId).orElse(null);

        if(Objects.isNull(existingDataElement)){

            throw new CustomException(HttpStatus.BAD_REQUEST, ClientMessages.FAILED_ADD.getMsgCode(), "no_data_element_found_by_the_given_data_element_id");
        }

        existingDataElement.setClDataElementCategorySet(clDataElementCategorySet);

        return repo.save(existingDataElement);

    }

    @Override
    public ClDataElement edit(ClDataElement clDataElement) throws CustomException {

        this.getByDataElementId(clDataElement.getDataElementId());

        return repo.save(clDataElement);

    }

    @Override
    public void deleteByDataElementId(int dataElementId) throws CustomException {

        ClDataElement clDataElement = this.getByDataElementId(dataElementId);

        repo.delete(clDataElement);

    }

    @Override
    public Page<ClDataElement> getList(Pageable pageable) {

        return repo.findAll(pageable);

    }

    @Override
    public ClDataElement getByDataElementId(int dataElementId) throws CustomException {

        ClDataElement clDataElement = repo.findById(dataElementId).orElse(null);

        if (Objects.isNull(clDataElement)) {

            throw new CustomException(HttpStatus.NOT_FOUND, ClientMessages.NO_RECORDS_FOUND.getMsgCode(), "no_cl_data_element_found_by_the_given_data_element_id");

        }

        return clDataElement;

    }

    @Override
    public ClDataElement getByUid(String uid) throws CustomException {

        ClDataElement clDataElement = repo.findClDataElementByUid(uid);

        if (Objects.isNull(clDataElement)) {

            throw new CustomException(HttpStatus.NOT_FOUND, ClientMessages.NO_RECORDS_FOUND.getMsgCode(), "no_cl_data_element_found_by_the_given_uid");

        }

        return clDataElement;
    }

}
