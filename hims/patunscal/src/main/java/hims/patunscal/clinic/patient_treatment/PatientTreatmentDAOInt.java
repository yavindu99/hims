package hims.patunscal.clinic.patient_treatment;

import hims.common.CustomException;

public interface PatientTreatmentDAOInt {

    PatientTreatment add(PatientTreatment history)throws CustomException;
    PatientTreatment edit(PatientTreatment history);
    PatientTreatment getByObjectId(String id);
    void deleteByObjectId(String id);
}
