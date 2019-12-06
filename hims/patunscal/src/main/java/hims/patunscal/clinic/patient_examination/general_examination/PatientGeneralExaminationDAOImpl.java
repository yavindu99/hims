package hims.patunscal.clinic.patient_examination.general_examination;

import hims.common.ClientMessages;
import hims.common.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class PatientGeneralExaminationDAOImpl implements PatientGeneralExaminationDAOInt {

    private PatientGeneralExaminationRepository repo;

    @Autowired
    public PatientGeneralExaminationDAOImpl(PatientGeneralExaminationRepository repo) {
        this.repo = repo;
    }

    @Override
    public PatientGeneralExamination add(PatientGeneralExamination patientGeneralExamination) throws CustomException {

        PatientGeneralExamination generalExamination;

        try {

            generalExamination = repo.save(patientGeneralExamination);

        }catch (DuplicateKeyException ex){

            throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "cl_patient_visit_id_is_already_exists");

        }

        return generalExamination;

    }

    @Override
    public PatientGeneralExamination getByVisitId(String visitId) {

        return repo.findPatientGeneralExaminationByVisitId(visitId);
    }

    @Override
    public void deleteByObjectId(String id) {

        repo.deleteById(id);

    }
}
