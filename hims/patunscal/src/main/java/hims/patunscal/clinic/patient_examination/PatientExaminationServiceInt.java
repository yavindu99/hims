package hims.patunscal.clinic.patient_examination;

import hims.common.CustomResponseMainBody;

public interface PatientExaminationServiceInt {

    CustomResponseMainBody add(PatientExamination patientExamination);
    CustomResponseMainBody edit(PatientExamination patientExamination);
    CustomResponseMainBody getByVisitId(String visitId);
    CustomResponseMainBody deleteByVisitId(String visitId);


}
