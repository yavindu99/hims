package hims.patunscal.clinic.patient_examination;

import hims.patunscal.clinic.patient_examination.abdomen_examination.PatientAbdomenExamination;
import hims.patunscal.clinic.patient_examination.cardiovascular_examination.PatientCardiovascularExamination;
import hims.patunscal.clinic.patient_examination.general_examination.PatientGeneralExamination;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PatientExamination {

    @NotNull(message = "cl_patient_visit_is_required")
    @NotEmpty(message = "cl_patient_visit_id_must_not_be_empty")
    private String visitId;

    @Valid
    private PatientGeneralExamination generalExamination;

    @Valid
    private PatientAbdomenExamination abdomenExamination;

    @Valid
    private PatientCardiovascularExamination cardiovascularExamination;

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public PatientGeneralExamination getGeneralExamination() {
        return generalExamination;
    }

    public void setGeneralExamination(PatientGeneralExamination generalExamination) {
        this.generalExamination = generalExamination;
    }

    public PatientAbdomenExamination getAbdomenExamination() {
        return abdomenExamination;
    }

    public void setAbdomenExamination(PatientAbdomenExamination abdomenExamination) {
        this.abdomenExamination = abdomenExamination;
    }

    public PatientCardiovascularExamination getCardiovascularExamination() {
        return cardiovascularExamination;
    }

    public void setCardiovascularExamination(PatientCardiovascularExamination cardiovascularExamination) {
        this.cardiovascularExamination = cardiovascularExamination;
    }
}
