package hims.patunscal.clinic.patient_referral;

import hims.common.CustomResponseMainBody;

public interface PatientReferralServiceInt {

    CustomResponseMainBody add(PatientReferral referral);
    CustomResponseMainBody edit(PatientReferral referral);
    CustomResponseMainBody getByObjectId(String id);
    CustomResponseMainBody deleteByObjectId(String id);
}
