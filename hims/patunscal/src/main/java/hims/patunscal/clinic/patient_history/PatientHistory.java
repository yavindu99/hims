package hims.patunscal.clinic.patient_history;

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

@Document(collection = "cl_patient_history")
public class PatientHistory {

    @Id
    private String id;

    @NotNull(message = "cl_patient_visit_is_required")
    @NotEmpty(message = "cl_patient_visit_id_must_not_be_empty")
    @Indexed(unique = true)
    private String visitId;

    @Valid
    private List<Level1Element> methodOfRegistrationOptionList = new ArrayList<>();

    @Valid
    private List<Level1Element> subFertilityHistoryOptionList = new ArrayList<>();

    @Valid
    private List<Level1Element> gynacologicalHistoryOptionList = new ArrayList<>();

    @Valid
    private List<Level1Element> obstetricHistoryOptionList = new ArrayList<>();

    @Valid
    private List<Level1Element> previousPregnanciesOptionList = new ArrayList<>();

    @Valid
    private List<Level1Element> miscarriagesOptionList = new ArrayList<>();

    @Valid
    private List<Level1Element> ectopicPregnanciesOptionList = new ArrayList<>();

    @Valid
    private List<Level1Element> pastSurgicalHistoryOptionList = new ArrayList<>();

    @Valid
    private List<Level1Element> pastMedicalHistoryOptionList = new ArrayList<>();

    @Valid
    private List<Level1Element> allergyHistoryOptionList = new ArrayList<>();

    @Valid
    private List<Level1Element> contraceptionHistoryOptionList = new ArrayList<>();

    @Valid
    private List<Level1Element> coitalHistoryOptionList = new ArrayList<>();

    @Valid
    private List<Level1Element> socialHistoryOptionList = new ArrayList<>();

    @Valid
    private List<Level1Element> drugHistoryOptionList = new ArrayList<>();

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

    public List<Level1Element> getMethodOfRegistrationOptionList() {
        return methodOfRegistrationOptionList;
    }

    public void setMethodOfRegistrationOptionList(List<Level1Element> methodOfRegistrationOptionList) {
        this.methodOfRegistrationOptionList = methodOfRegistrationOptionList;
    }

    public List<Level1Element> getSubFertilityHistoryOptionList() {
        return subFertilityHistoryOptionList;
    }

    public void setSubFertilityHistoryOptionList(List<Level1Element> subFertilityHistoryOptionList) {
        this.subFertilityHistoryOptionList = subFertilityHistoryOptionList;
    }

    public List<Level1Element> getGynacologicalHistoryOptionList() {
        return gynacologicalHistoryOptionList;
    }

    public void setGynacologicalHistoryOptionList(List<Level1Element> gynacologicalHistoryOptionList) {
        this.gynacologicalHistoryOptionList = gynacologicalHistoryOptionList;
    }

    public List<Level1Element> getObstetricHistoryOptionList() {
        return obstetricHistoryOptionList;
    }

    public void setObstetricHistoryOptionList(List<Level1Element> obstetricHistoryOptionList) {
        this.obstetricHistoryOptionList = obstetricHistoryOptionList;
    }

    public List<Level1Element> getPreviousPregnanciesOptionList() {
        return previousPregnanciesOptionList;
    }

    public void setPreviousPregnanciesOptionList(List<Level1Element> previousPregnanciesOptionList) {
        this.previousPregnanciesOptionList = previousPregnanciesOptionList;
    }

    public List<Level1Element> getMiscarriagesOptionList() {
        return miscarriagesOptionList;
    }

    public void setMiscarriagesOptionList(List<Level1Element> miscarriagesOptionList) {
        this.miscarriagesOptionList = miscarriagesOptionList;
    }

    public List<Level1Element> getEctopicPregnanciesOptionList() {
        return ectopicPregnanciesOptionList;
    }

    public void setEctopicPregnanciesOptionList(List<Level1Element> ectopicPregnanciesOptionList) {
        this.ectopicPregnanciesOptionList = ectopicPregnanciesOptionList;
    }

    public List<Level1Element> getPastSurgicalHistoryOptionList() {
        return pastSurgicalHistoryOptionList;
    }

    public void setPastSurgicalHistoryOptionList(List<Level1Element> pastSurgicalHistoryOptionList) {
        this.pastSurgicalHistoryOptionList = pastSurgicalHistoryOptionList;
    }

    public List<Level1Element> getPastMedicalHistoryOptionList() {
        return pastMedicalHistoryOptionList;
    }

    public void setPastMedicalHistoryOptionList(List<Level1Element> pastMedicalHistoryOptionList) {
        this.pastMedicalHistoryOptionList = pastMedicalHistoryOptionList;
    }

    public List<Level1Element> getAllergyHistoryOptionList() {
        return allergyHistoryOptionList;
    }

    public void setAllergyHistoryOptionList(List<Level1Element> allergyHistoryOptionList) {
        this.allergyHistoryOptionList = allergyHistoryOptionList;
    }

    public List<Level1Element> getContraceptionHistoryOptionList() {
        return contraceptionHistoryOptionList;
    }

    public void setContraceptionHistoryOptionList(List<Level1Element> contraceptionHistoryOptionList) {
        this.contraceptionHistoryOptionList = contraceptionHistoryOptionList;
    }

    public List<Level1Element> getCoitalHistoryOptionList() {
        return coitalHistoryOptionList;
    }

    public void setCoitalHistoryOptionList(List<Level1Element> coitalHistoryOptionList) {
        this.coitalHistoryOptionList = coitalHistoryOptionList;
    }

    public List<Level1Element> getSocialHistoryOptionList() {
        return socialHistoryOptionList;
    }

    public void setSocialHistoryOptionList(List<Level1Element> socialHistoryOptionList) {
        this.socialHistoryOptionList = socialHistoryOptionList;
    }

    public List<Level1Element> getDrugHistoryOptionList() {
        return drugHistoryOptionList;
    }

    public void setDrugHistoryOptionList(List<Level1Element> drugHistoryOptionList) {
        this.drugHistoryOptionList = drugHistoryOptionList;
    }

    public UnsCommonFields getCommonFields() {
        return commonFields;
    }

    public void setCommonFields(UnsCommonFields commonFields) {
        this.commonFields = commonFields;
    }
}
