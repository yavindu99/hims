package hims.admical.clinic.cl_level_1;

import hims.common.ClientMessages;
import hims.common.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Objects;

@Repository
@Transactional
public class ClLevel1DAOImpl implements ClLevel1DAOInt {

    private ClLevel1RepositoryInt repo;

    @Autowired
    public ClLevel1DAOImpl(ClLevel1RepositoryInt repo) {
        this.repo = repo;
    }

    @Override
    public ClLevel1 add(ClLevel1 clLevel1) throws CustomException {

        ClLevel1 clLevel1ByDuid = repo.findClLevel1ByDuid(clLevel1.getDuid());
        ClLevel1 clLevel1ByName = repo.findClLevel1ByName(clLevel1.getName());

        if (Objects.nonNull(clLevel1.getDuid()) && Objects.nonNull(clLevel1ByDuid)) {

            throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "duplicate_entry_level_1_option_developer_uid_cannot_be_duplicated");

        } else if (Objects.nonNull(clLevel1ByName)) {

            throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "duplicate_entry_level_1_option_name_cannot_be_duplicated");

        }

        return repo.save(clLevel1);

    }

    @Override
    public Page<ClLevel1> getList(Pageable pageable) {

        return repo.findAll(pageable);

    }

    @Override
    public ClLevel1 getByL1id(int l1id) throws CustomException {

        ClLevel1 existingClLevel1 = repo.findById(l1id).orElse(null);

        if (Objects.isNull(existingClLevel1)) {

            throw new CustomException(HttpStatus.NOT_FOUND, ClientMessages.FAILED_UPDATE.getMsgCode(), "no_level_1_option_found_by_the_given_id");

        }

        return existingClLevel1;

    }

    @Override
    public ClLevel1 edit(ClLevel1 clLevel1) throws CustomException {

        this.getByL1id(clLevel1.getL1id());

        return repo.save(clLevel1);

    }

    @Override
    public void deleteByL1id(int l1id) throws CustomException {

        ClLevel1 existingClLevel1 = this.getByL1id(l1id);

        repo.delete(existingClLevel1);

    }
}
