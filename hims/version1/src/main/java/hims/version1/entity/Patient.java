package hims.version1.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patientdemographic")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="patientId")
public class Patient implements Serializable {


    @Id
    @Column(name = "patientID")
    private String patientId;

    private String patientNIC;

    private String patientPersonalTitle;

    private String patientName;

    private String  patientSex;

    private String patientMaritalStatus;

    private String patientDateofbirth;

    private String patientAddressLine03;

    private String patientAddressDistrict;

    private String drugAllergies;

    private String foodAllergies;

    private  String otherAllergies;

    private String patientBloodType;

    @OneToMany(mappedBy = "patient")
    private List<ClinicRegistration> clinicRegistrationList = new ArrayList<>();


    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientNIC() {
        return patientNIC;
    }

    public void setPatientNIC(String patientNIC) {
        this.patientNIC = patientNIC;
    }

    public String getPatientPersonalTitle() {
        return patientPersonalTitle;
    }

    public void setPatientPersonalTitle(String patientPersonalTitle) {
        this.patientPersonalTitle = patientPersonalTitle;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public String getPatientMaritalStatus() {
        return patientMaritalStatus;
    }

    public void setPatientMaritalStatus(String patientMaritalStatus) {
        this.patientMaritalStatus = patientMaritalStatus;
    }

    public String getPatientDateofbirth() {
        return patientDateofbirth;
    }

    public void setPatientDateofbirth(String patientDateofbirth) {
        this.patientDateofbirth = patientDateofbirth;
    }

    public String getPatientAddressLine03() {
        return patientAddressLine03;
    }

    public void setPatientAddressLine03(String patientAddressLine03) {
        this.patientAddressLine03 = patientAddressLine03;
    }

    public String getPatientAddressDistrict() {
        return patientAddressDistrict;
    }

    public void setPatientAddressDistrict(String patientAddressDistrict) {
        this.patientAddressDistrict = patientAddressDistrict;
    }

    public String getDrugAllergies() {
        return drugAllergies;
    }

    public void setDrugAllergies(String drugAllergies) {
        this.drugAllergies = drugAllergies;
    }

    public String getFoodAllergies() {
        return foodAllergies;
    }

    public void setFoodAllergies(String foodAllergies) {
        this.foodAllergies = foodAllergies;
    }

    public String getOtherAllergies() {
        return otherAllergies;
    }

    public void setOtherAllergies(String otherAllergies) {
        this.otherAllergies = otherAllergies;
    }

    public String getPatientBloodType() {
        return patientBloodType;
    }

    public void setPatientBloodType(String patientBloodType) {
        this.patientBloodType = patientBloodType;
    }

    @JsonIgnore
    public List<ClinicRegistration> getClinicRegistrationList() {
        return clinicRegistrationList;
    }

    public void setClinicRegistrationList(List<ClinicRegistration> clinicRegistrationList) {
        this.clinicRegistrationList = clinicRegistrationList;
    }

}
