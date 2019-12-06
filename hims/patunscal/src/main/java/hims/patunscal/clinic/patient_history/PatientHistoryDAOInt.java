package hims.patunscal.clinic.patient_history;

import hims.common.CustomException;

public interface PatientHistoryDAOInt {

    PatientHistory add(PatientHistory history)throws CustomException;
    PatientHistory edit(PatientHistory history);
    PatientHistory getByObjectId(String id);
    void deleteByObjectId(String id);

}
