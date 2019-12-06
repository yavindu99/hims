package hims.patunscal.clinic.patient_examination.cardiovascular_examination;

import hims.common.CustomException;

public interface PatientCardiovascularExaminationDAOInt {

    PatientCardiovascularExamination add(PatientCardiovascularExamination patientCardiovascularExamination)throws CustomException;
    PatientCardiovascularExamination getByVisitId(String visitId);
    void deleteByObjectId(String id);

}
