package hims.patunscal.clinic.patient_examination.general_examination;

import hims.common.CustomException;

public interface PatientGeneralExaminationDAOInt {

    PatientGeneralExamination add(PatientGeneralExamination patientGeneralExamination)throws CustomException;
    PatientGeneralExamination getByVisitId(String visitId);
    void deleteByObjectId(String id);

}
