package hims.patunscal.clinic.patient_visit;

import hims.common.CustomException;

public interface PatientVisitDAOInt {

    PatientVisit add(PatientVisit patientVisit)throws CustomException;
    PatientVisit getByObjectId(String objectId)throws CustomException;
}
