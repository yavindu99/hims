package hims.patunscal.clinic.patient_examination.abdomen_examination;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientAbdomenExaminationRepository extends MongoRepository<PatientAbdomenExamination,String> {


    PatientAbdomenExamination findPatientAbdomenExaminationByVisitId(String visitId);

}
