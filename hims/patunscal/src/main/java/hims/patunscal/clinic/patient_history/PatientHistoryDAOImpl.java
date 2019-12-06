package hims.patunscal.clinic.patient_history;

import hims.common.ClientMessages;
import hims.common.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class PatientHistoryDAOImpl implements PatientHistoryDAOInt {

    private PatientHistoryRepository repo;

    @Autowired
    public PatientHistoryDAOImpl(PatientHistoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public PatientHistory add(PatientHistory history)throws CustomException {

        PatientHistory newHistory;

        try {

            newHistory = repo.save(history);

        }catch (DuplicateKeyException ex){

            throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "cl_patient_visit_id_is_already_exists");

        }

        return newHistory;
    }

    @Override
    public PatientHistory edit(PatientHistory history) {

        PatientHistory newHistory = repo.save(history);

        return newHistory;
    }

    @Override
    public PatientHistory getByObjectId(String id) {

        return repo.findById(id).orElse(null);

    }

    @Override
    public void deleteByObjectId(String id) {

        repo.deleteById(id);
    }

}
