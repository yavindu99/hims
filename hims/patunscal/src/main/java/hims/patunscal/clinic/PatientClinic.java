package hims.patunscal.clinic;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PatientClinic {

    @NotNull(message = "clinic_file_no_is_required")
    @NotEmpty(message = "clinic_file_no_must_not_be_empty")
    private String clinicFileNo;

    @NotNull(message = "clinic_type_is_required")
    @NotEmpty(message = "clinic_type_must_not_be_empty")
    private String clinicType;

    @Valid
    private Patient patient;

    public String getClinicFileNo() {
        return clinicFileNo;
    }

    public String getClinicType() {
        return clinicType;
    }

    public void setClinicType(String clinicType) {
        this.clinicType = clinicType;
    }

    public void setClinicFileNo(String clinicFileNo) {
        this.clinicFileNo = clinicFileNo;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
