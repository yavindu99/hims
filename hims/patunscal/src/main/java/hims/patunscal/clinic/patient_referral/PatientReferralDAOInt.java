package hims.patunscal.clinic.patient_referral;

import hims.common.CustomException;

public interface PatientReferralDAOInt {

    PatientReferral add(PatientReferral history)throws CustomException;
    PatientReferral edit(PatientReferral history);
    PatientReferral getByObjectId(String id);
    void deleteByObjectId(String id);
}
