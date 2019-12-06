package hims.admical.administrative.institute;

import hims.admical.administrative.user.CommonFields;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "institute_type")
public class InstituteType {

    @Id
    private String instituteType;

    @OneToMany(targetEntity = Institute.class,mappedBy = "instituteType",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Collection<Institute> instituteList;

    @Embedded
    private CommonFields commonFields;

    public String getInstituteType() {
        return instituteType;
    }

    public void setInstituteType(String instituteType) {
        this.instituteType = instituteType;
    }

    public Collection<Institute> getInstituteList() {
        return instituteList;
    }

    public void setInstituteList(Collection<Institute> instituteList) {
        this.instituteList = instituteList;
    }
}
