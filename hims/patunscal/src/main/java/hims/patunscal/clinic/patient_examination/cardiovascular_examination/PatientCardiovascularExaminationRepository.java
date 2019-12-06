package hims.patunscal.clinic.patient_examination.cardiovascular_examination;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientCardiovascularExaminationRepository extends MongoRepository<PatientCardiovascularExamination,String> {


    PatientCardiovascularExamination findPatientCardiovascularExaminationByVisitId(String visitId);

}
