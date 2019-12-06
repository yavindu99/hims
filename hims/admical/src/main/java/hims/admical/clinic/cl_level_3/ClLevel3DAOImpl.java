package hims.admical.clinic.cl_level_3;

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
public class ClLevel3DAOImpl implements ClLevel3DAOInt {

    private ClLevel3RepositoryInt repo;

    @Autowired
    public ClLevel3DAOImpl(ClLevel3RepositoryInt repo) {
        this.repo = repo;
    }

    @Override
    public List<ClLevel3> addList(List<ClLevel3> clLevel3List) throws CustomException {

        List<ClLevel3> newClLevel3List;

        try{

            newClLevel3List = repo.saveAll(clLevel3List);

        }catch (DuplicateKeyException ex){

            throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "duplicate_entry_level_3_option_developer_uid_or_name_cannot_be_duplicated");

        }catch (DataIntegrityViolationException ex){

            throw new CustomException(HttpStatus.BAD_REQUEST, ClientMessages.FAILED_ADD.getMsgCode(), "add_level_2_option_before_adding_level_3_options");

        }catch (Exception ex){

            throw new CustomException(HttpStatus.BAD_REQUEST, ClientMessages.FAILED_ADD.getMsgCode(), "duplicate_entry_level_3_option_developer_uid_or_name_cannot_be_duplicated_or_add_level_2_option_before_adding_level_3_options");

        }

        return newClLevel3List;

    }

    @Override
    public ClLevel3 add(ClLevel3 clLevel3) throws CustomException {

        ClLevel3 clLevel3ByDuid = repo.findClLevel3ByDuid(clLevel3.getDuid());
        ClLevel3 clLevel3ByName = repo.findClLevel3ByName(clLevel3.getName());

        if (Objects.nonNull(clLevel3ByDuid)) {

            throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "duplicate_entry_level_3_option_developer_uid_cannot_be_duplicated");

        } else if (Objects.nonNull(clLevel3ByName)) {

            throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "duplicate_entry_level_3_option_name_cannot_be_duplicated");

        }

        return repo.save(clLevel3);

    }

    @Override
    public Page<ClLevel3> getList(Pageable pageable) {

        return repo.findAll(pageable);

    }

    @Override
    public ClLevel3 getByL3id(int l3id) throws CustomException {

        ClLevel3 existingClLevel3 = repo.findById(l3id).orElse(null);

        if (Objects.isNull(existingClLevel3)) {

            throw new CustomException(HttpStatus.NOT_FOUND, ClientMessages.FAILED_UPDATE.getMsgCode(), "no_level_3_option_found_by_the_given_id");

        }

        return existingClLevel3;
    }

    @Override
    public ClLevel3 edit(ClLevel3 clLevel3) throws CustomException {

        this.getByL3id(clLevel3.getL3id());

        return repo.save(clLevel3);

    }

    @Override
    public void deleteByL3id(int l3id) throws CustomException {

        ClLevel3 existingClLevel3 = this.getByL3id(l3id);

        repo.delete(existingClLevel3);

    }
}
