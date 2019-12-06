package hims.patunscal.clinic.patient_examination.abdomen_examination;

import hims.common.ClientMessages;
import hims.common.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class PatientAbdomenExaminationDAOImpl implements PatientAbdomenExaminationDAOInt {

    private PatientAbdomenExaminationRepository repo;

    @Autowired
    public PatientAbdomenExaminationDAOImpl(PatientAbdomenExaminationRepository repo) {
        this.repo = repo;
    }

    @Override
    public PatientAbdomenExamination add(PatientAbdomenExamination patientAbdomenExamination) throws CustomException {

        PatientAbdomenExamination abdomenExamination;

        try {

            abdomenExamination = repo.save(patientAbdomenExamination);

        }catch (DuplicateKeyException ex){

            throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "cl_patient_visit_id_is_already_exists");

        }

        return abdomenExamination;

    }

    @Override
    public PatientAbdomenExamination getByVisitId(String visitId) {

        return repo.findPatientAbdomenExaminationByVisitId(visitId);

    }

    @Override
    public void deleteByObjectId(String id) {

        repo.deleteById(id);

    }
}
