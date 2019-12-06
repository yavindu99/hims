package hims.patunscal.clinic.patient_examination.general_examination;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientGeneralExaminationRepository extends MongoRepository<PatientGeneralExamination,String> {

    PatientGeneralExamination findPatientGeneralExaminationByVisitId(String visitId);


}
