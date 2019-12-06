package hims.patunscal.clinic.patient_examination.cardiovascular_examination;

import hims.common.ClientMessages;
import hims.common.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class PatientCardiovascularExaminationDAOImpl implements PatientCardiovascularExaminationDAOInt {

    private PatientCardiovascularExaminationRepository repo;

    @Autowired
    public PatientCardiovascularExaminationDAOImpl(PatientCardiovascularExaminationRepository repo) {
        this.repo = repo;
    }

    @Override
    public PatientCardiovascularExamination add(PatientCardiovascularExamination patientCardiovascularExamination) throws CustomException {

        PatientCardiovascularExamination cardiovascularExamination;

        try {

            cardiovascularExamination = repo.save(patientCardiovascularExamination);

        }catch (DuplicateKeyException ex){

            throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "cl_patient_visit_id_is_already_exists");

        }

        return cardiovascularExamination;

    }

    @Override
    public PatientCardiovascularExamination getByVisitId(String visitId) {

        return repo.findPatientCardiovascularExaminationByVisitId(visitId);

    }

    @Override
    public void deleteByObjectId(String id) {

        repo.deleteById(id);
    }
}
