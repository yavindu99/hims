package hims.patunscal.clinic.patient_visit;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientVisitRepository extends MongoRepository<PatientVisit,String> {

}
