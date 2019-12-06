package hims.admical.administrative.institute;

import hims.admical.administrative.user.CommonFields;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "institute_moh_id")
public class InstituteMOHId {

    @Id
    private String instituteMOHId;

    @OneToMany(targetEntity = Institute.class,mappedBy = "instituteMOHId",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Collection<Institute> instituteList;

    @Embedded
    private CommonFields commonFields;

    public String getInstituteMOHId() {
        return instituteMOHId;
    }

    public void setInstituteMOHId(String instituteMOHId) {
        this.instituteMOHId = instituteMOHId;
    }

    public Collection<Institute> getInstituteList() {
        return instituteList;
    }

    public void setInstituteList(Collection<Institute> instituteList) {
        this.instituteList = instituteList;
    }
}