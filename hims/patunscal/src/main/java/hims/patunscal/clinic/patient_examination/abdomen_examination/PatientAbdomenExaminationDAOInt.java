package hims.patunscal.clinic.patient_examination.abdomen_examination;

import hims.common.CustomException;

public interface PatientAbdomenExaminationDAOInt {

    PatientAbdomenExamination add(PatientAbdomenExamination patientAbdomenExamination)throws CustomException;
    PatientAbdomenExamination getByVisitId(String visitId);
    void deleteByObjectId(String id);


}
