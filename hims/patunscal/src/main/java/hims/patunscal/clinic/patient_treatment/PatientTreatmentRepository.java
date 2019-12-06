package hims.patunscal.clinic.patient_treatment;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientTreatmentRepository extends MongoRepository<PatientTreatment,String> {


}
