package hims.admical.clinic.cl_level_2;

import hims.common.ClientMessages;
import hims.common.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Repository
@Transactional
public class ClLevel2DAOImpl implements ClLevel2DAOInt {

    private ClLevel2RepositoryInt repo;

    @Autowired
    public ClLevel2DAOImpl(ClLevel2RepositoryInt repo) {
        this.repo = repo;
    }

    @Override
    public List<ClLevel2> addList(List<ClLevel2> clLevel2List) throws CustomException {

        List<ClLevel2> newClLevel2List;

        try{

            newClLevel2List = repo.saveAll(clLevel2List);

        }catch (DuplicateKeyException ex){

            throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "duplicate_entry_level_2_option_developer_uid_or_name_cannot_be_duplicated");

        }catch (DataIntegrityViolationException ex){

            throw new CustomException(HttpStatus.BAD_REQUEST, ClientMessages.FAILED_ADD.getMsgCode(), "add_level_1_option_before_adding_level_2_options");

        }catch (Exception ex){

            throw new CustomException(HttpStatus.BAD_REQUEST, ClientMessages.FAILED_ADD.getMsgCode(), "duplicate_entry_level_2_option_developer_uid_or_name_cannot_be_duplicated_or_add_level_1_option_before_adding_level_2_options");

        }

        return newClLevel2List;

    }

    @Override
    public ClLevel2 add(ClLevel2 clLevel2) throws CustomException {

        ClLevel2 clLevel2ByDuid = repo.findClLevel2ByDuid(clLevel2.getDuid());
        ClLevel2 clLevel2ByName = repo.findClLevel2ByName(clLevel2.getName());

        if (Objects.nonNull(clLevel2ByDuid)) {

            throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "duplicate_entry_level_2_option_developer_uid_cannot_be_duplicated");

        } else if (Objects.nonNull(clLevel2ByName)) {

            throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "duplicate_entry_level_2_option_name_cannot_be_duplicated");

        }

        return repo.save(clLevel2);

    }

    @Override
    public Page<ClLevel2> getList(Pageable pageable) {

        return repo.findAll(pageable);

    }

    @Override
    public ClLevel2 getByL2id(int l2id) throws CustomException {

        ClLevel2 existingClLevel2 = repo.findById(l2id).orElse(null);

        if (Objects.isNull(existingClLevel2)) {

            throw new CustomException(HttpStatus.NOT_FOUND, ClientMessages.FAILED_UPDATE.getMsgCode(), "no_level_2_option_found_by_the_given_id");

        }

        return existingClLevel2;
    }

    @Override
    public ClLevel2 edit(ClLevel2 clLevel2) throws CustomException {

        this.getByL2id(clLevel2.getL2id());

        return repo.save(clLevel2);

    }

    @Override
    public void deleteByL2id(int l2id) throws CustomException {

        ClLevel2 existingClLevel2 = this.getByL2id(l2id);

        repo.delete(existingClLevel2);

    }
}
