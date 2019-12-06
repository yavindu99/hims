package hims.patunscal.clinic.patient_lab_investigation;


import hims.common.CustomResponseMainBody;

public interface PatientLabInvestigationServiceInt {

    CustomResponseMainBody add(PatientLabInvestigation investigation);
    CustomResponseMainBody edit(PatientLabInvestigation investigation);
    CustomResponseMainBody getByObjectId(String id);
    CustomResponseMainBody deleteByObjectId(String id);

}
