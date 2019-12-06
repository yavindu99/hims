package hims.patunscal.clinic;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Patient {

    @NotNull(message = "patient_id_is_required")
    @NotEmpty(message = "patient_id_must_not_be_empty")
    private String patientId;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

}
