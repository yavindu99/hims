package hims.patunscal.clinic.patient_history;

import hims.common.CustomResponseMainBody;

public interface PatientHistoryServiceInt {

    CustomResponseMainBody add(PatientHistory history);
    CustomResponseMainBody edit(PatientHistory history);
    CustomResponseMainBody getByObjectId(String id);
    CustomResponseMainBody deleteByObjectId(String id);

}
