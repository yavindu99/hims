package hims.patunscal.clinic.patient_treatment;

import hims.common.CustomResponseMainBody;

public interface PatientTreatmentServiceInt {

    CustomResponseMainBody add(PatientTreatment treatment);
    CustomResponseMainBody edit(PatientTreatment treatment);
    CustomResponseMainBody getByObjectId(String id);
    CustomResponseMainBody deleteByObjectId(String id);
}
