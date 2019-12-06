package hims.patunscal.clinic.patient_visit;

import hims.patunscal.UnsCommonFields;
import hims.patunscal.clinic.PatientClinic;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Document(collection = "cl_patient_visit")
public class PatientVisit {

    @Id
    private String id;

    @NotNull(message = "cl_patient_clinic_is_required")
    @Valid
    private PatientClinic patientClinic;

    private UnsCommonFields commonFields;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PatientClinic getPatientClinic() {
        return patientClinic;
    }

    public void setPatientClinic(PatientClinic patientClinic) {
        this.patientClinic = patientClinic;
    }

    public UnsCommonFields getCommonFields() {
        return commonFields;
    }

    public void setCommonFields(UnsCommonFields commonFields) {
        this.commonFields = commonFields;
    }
}
