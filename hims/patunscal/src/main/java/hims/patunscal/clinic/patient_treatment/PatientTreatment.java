package hims.patunscal.clinic.patient_treatment;

import hims.patunscal.UnsCommonFields;
import hims.patunscal.clinic.Level1Element;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "patient_treatment")
public class PatientTreatment {

    @Id
    private String id;

    @NotNull(message = "cl_patient_visit_is_required")
    @NotEmpty(message = "cl_patient_visit_id_must_not_be_empty")
    @Indexed(unique = true)
    private String visitId;

    @Valid
    private List<Level1Element> treatmentOptionList = new ArrayList<>();

    private UnsCommonFields commonFields;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public List<Level1Element> getTreatmentOptionList() {
        return treatmentOptionList;
    }

    public void setTreatmentOptionList(List<Level1Element> treatmentOptionList) {
        this.treatmentOptionList = treatmentOptionList;
    }

    public UnsCommonFields getCommonFields() {
        return commonFields;
    }

    public void setCommonFields(UnsCommonFields commonFields) {
        this.commonFields = commonFields;
    }
}
