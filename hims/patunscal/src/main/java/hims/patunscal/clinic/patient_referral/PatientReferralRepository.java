package hims.patunscal.clinic.patient_referral;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientReferralRepository extends MongoRepository<PatientReferral,String> {
}
