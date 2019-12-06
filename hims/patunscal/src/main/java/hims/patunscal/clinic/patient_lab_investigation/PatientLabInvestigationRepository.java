package hims.patunscal.clinic.patient_lab_investigation;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientLabInvestigationRepository extends MongoRepository<PatientLabInvestigation,String> {

}
