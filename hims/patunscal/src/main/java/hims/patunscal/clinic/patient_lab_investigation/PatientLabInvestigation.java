package hims.patunscal.clinic.patient_lab_investigation;

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

@Document(collection = "cl_patient_lab_investigation")
public class PatientLabInvestigation {

  @Id
  private String id;

  @NotNull(message = "cl_patient_visit_is_required")
  @NotEmpty(message = "cl_patient_visit_id_must_not_be_empty")
  @Indexed(unique = true)
  private String visitId;

  @Valid
  private List<Level1Element> baseLineUssOptionList = new ArrayList<>();

  @Valid
  private List<Level1Element> hsgOptionList = new ArrayList<>();

  @Valid
  private List<Level1Element> tvsOptionList = new ArrayList<>();

  @Valid
  private List<Level1Element> otherInvestigationOptionList = new ArrayList<>();

  @Valid
  private List<Level1Element> lsFolliclesOptionList = new ArrayList<>();

  @Valid
  private List<Level1Element> sfaOptionList = new ArrayList<>();

  @Valid
  private List<Level1Element> ussScrotumOptionList = new ArrayList<>();

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

  public List<Level1Element> getBaseLineUssOptionList() {
    return baseLineUssOptionList;
  }

  public void setBaseLineUssOptionList(List<Level1Element> baseLineUssOptionList) {
    this.baseLineUssOptionList = baseLineUssOptionList;
  }

  public List<Level1Element> getHsgOptionList() {
    return hsgOptionList;
  }

  public void setHsgOptionList(List<Level1Element> hsgOptionList) {
    this.hsgOptionList = hsgOptionList;
  }

  public List<Level1Element> getTvsOptionList() {
    return tvsOptionList;
  }

  public void setTvsOptionList(List<Level1Element> tvsOptionList) {
    this.tvsOptionList = tvsOptionList;
  }

  public List<Level1Element> getOtherInvestigationOptionList() {
    return otherInvestigationOptionList;
  }

  public void setOtherInvestigationOptionList(List<Level1Element> otherInvestigationOptionList) {
    this.otherInvestigationOptionList = otherInvestigationOptionList;
  }

  public List<Level1Element> getLsFolliclesOptionList() {
    return lsFolliclesOptionList;
  }

  public void setLsFolliclesOptionList(List<Level1Element> lsFolliclesOptionList) {
    this.lsFolliclesOptionList = lsFolliclesOptionList;
  }

  public List<Level1Element> getSfaOptionList() {
    return sfaOptionList;
  }

  public void setSfaOptionList(List<Level1Element> sfaOptionList) {
    this.sfaOptionList = sfaOptionList;
  }

  public List<Level1Element> getUssScrotumOptionList() {
    return ussScrotumOptionList;
  }

  public void setUssScrotumOptionList(List<Level1Element> ussScrotumOptionList) {
    this.ussScrotumOptionList = ussScrotumOptionList;
  }

  public UnsCommonFields getCommonFields() {
    return commonFields;
  }

  public void setCommonFields(UnsCommonFields commonFields) {
    this.commonFields = commonFields;
  }
}
