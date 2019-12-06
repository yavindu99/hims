package hims.patunscal.clinic.patient_treatment;

import hims.common.ClientMessages;
import hims.common.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class PatientTreatmentDAOImpl implements PatientTreatmentDAOInt {

    private PatientTreatmentRepository repo;

    @Autowired
    public PatientTreatmentDAOImpl(PatientTreatmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public PatientTreatment add(PatientTreatment treatment)throws CustomException {

        PatientTreatment newTreatment;

        try {

            newTreatment = repo.save(treatment);

        }catch (DuplicateKeyException ex){

            throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "cl_patient_visit_id_is_already_exists");

        }

        return newTreatment;
    }

    @Override
    public PatientTreatment edit(PatientTreatment treatment) {

        PatientTreatment newTreatment = repo.save(treatment);

        return newTreatment;
    }

    @Override
    public PatientTreatment getByObjectId(String id) {

        return repo.findById(id).orElse(null);

    }

    @Override
    public void deleteByObjectId(String id) {

        repo.deleteById(id);
    }

}
