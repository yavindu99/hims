package hims.version1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "clinicadmission")
public class ClinicRegistration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clinicIndex")
    private  int clinicRegistrationId;

    @Column(name = "BHTClinicFileNo")
    private String clinicFileNo;

    private String departmentCode;

    @ManyToOne
    @JoinColumn(name = "patientID",insertable = false,updatable = false,nullable = false)
    @JsonBackReference
    private Patient patient;

    public int getClinicRegistrationId() {
        return clinicRegistrationId;
    }

    public void setClinicRegistrationId(int clinicRegistrationId) {
        this.clinicRegistrationId = clinicRegistrationId;
    }

    public String getClinicFileNo() {
        return clinicFileNo;
    }

    public void setClinicFileNo(String clinicFileNo) {
        this.clinicFileNo = clinicFileNo;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
