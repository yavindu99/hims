package hims.patunscal.clinic.patient_lab_investigation;

import hims.common.CustomException;

public interface PatientLabInvestigationDAOInt {

    PatientLabInvestigation add(PatientLabInvestigation investigation)throws CustomException;
    PatientLabInvestigation edit(PatientLabInvestigation investigation);
    PatientLabInvestigation getByObjectId(String id);
    void deleteByObjectId(String id);


}
