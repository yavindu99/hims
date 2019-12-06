package hims.patunscal.clinic.patient_examination.general_examination;

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

@Document(collection = "cl_patient_general_examination")
public class PatientGeneralExamination {

    @Id
    private String id;

    @Indexed(unique = true)
    private String visitId;

    @Valid
    @NotNull(message = "level1_element_list_is_required")
    @NotEmpty(message = "level1_element_list_must_not_be_empty")
    private List<Level1Element> optionList = new ArrayList<>();

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

    public List<Level1Element> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Level1Element> optionList) {
        this.optionList = optionList;
    }

    public UnsCommonFields getCommonFields() {
        return commonFields;
    }

    public void setCommonFields(UnsCommonFields commonFields) {
        this.commonFields = commonFields;
    }
}
