package hims.patunscal.clinic.patient_procedure;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientProcedureRepository extends MongoRepository<PatientProcedure, String> {

}
