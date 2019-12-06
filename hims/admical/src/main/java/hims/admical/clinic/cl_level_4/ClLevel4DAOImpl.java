package hims.admical.clinic.cl_level_4;

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
public class ClLevel4DAOImpl implements ClLevel4DAOInt {

    private ClLevel4RepositoryInt repo;

    @Autowired
    public ClLevel4DAOImpl(ClLevel4RepositoryInt repo) {
        this.repo = repo;
    }

    @Override
    public List<ClLevel4> addList(List<ClLevel4> clLevel4List) throws CustomException {

        List<ClLevel4> newClLevel4List;

        try{

            newClLevel4List = repo.saveAll(clLevel4List);

        }catch (DuplicateKeyException ex){

            throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "duplicate_entry_level_4_option_developer_uid_or_name_cannot_be_duplicated");

        }catch (DataIntegrityViolationException ex){

            throw new CustomException(HttpStatus.BAD_REQUEST, ClientMessages.FAILED_ADD.getMsgCode(), "add_level_3_option_before_adding_level_4_options");

        }catch (Exception ex){

            throw new CustomException(HttpStatus.BAD_REQUEST, ClientMessages.FAILED_ADD.getMsgCode(), "duplicate_entry_level_4_option_developer_uid_or_name_cannot_be_duplicated_or_add_level_3_option_before_adding_level_4_options");

        }

        return newClLevel4List;

    }

    @Override
    public ClLevel4 add(ClLevel4 clLevel4) throws CustomException {

        ClLevel4 clLevel4ByDuid = repo.findClLevel4ByDuid(clLevel4.getDuid());
        ClLevel4 clLevel4ByName = repo.findClLevel4ByName(clLevel4.getName());

        if (Objects.nonNull(clLevel4ByDuid)) {

            throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "duplicate_entry_level_4_option_developer_uid_cannot_be_duplicated");

        } else if (Objects.nonNull(clLevel4ByName)) {

            throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "duplicate_entry_level_4_option_name_cannot_be_duplicated");

        }

        return repo.save(clLevel4);

    }

    @Override
    public Page<ClLevel4> getList(Pageable pageable) {

        return repo.findAll(pageable);

    }

    @Override
    public ClLevel4 getByL4id(int l4id) throws CustomException {

        ClLevel4 existingClLevel4 = repo.findById(l4id).orElse(null);

        if (Objects.isNull(existingClLevel4)) {

            throw new CustomException(HttpStatus.NOT_FOUND, ClientMessages.FAILED_UPDATE.getMsgCode(), "no_level_4_option_found_by_the_given_id");

        }

        return existingClLevel4;
    }

    @Override
    public ClLevel4 edit(ClLevel4 clLevel4) throws CustomException {

        this.getByL4id(clLevel4.getL4id());

        return repo.save(clLevel4);

    }

    @Override
    public void deleteByL4id(int l4id) throws CustomException {

        ClLevel4 existingClLevel4 = this.getByL4id(l4id);

        repo.delete(existingClLevel4);

    }
}
