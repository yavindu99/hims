package hims.admical.clinic.cl_level_3;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import hims.admical.administrative.department.departmentType.DepartmentType;
import hims.admical.clinic.cl_level_2.ClLevel2;
import hims.admical.clinic.cl_level_4.ClLevel4;
import hims.common.Confirmation;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cl_level_3")
public class ClLevel3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int l3id;

    @Column(unique = true)
    @Size(max = 255, message = "level_3_option_developer_unique_id_exceeds_max_length_of_255")
    private String duid;

    @Column(nullable = false, unique = true)
    @NotNull(message = "level_3_option_name_is_required")
    @NotEmpty(message = "level_3_option_name_cannot_be_empty")
    @Size(max = 255, message = "level_3_option_name_exceeds_max_length_of_255")
    private String name;

    @Size(max = 255, message = "level_3_option_description_exceeds_max_length_of_255")
    private String description;

    @Enumerated(EnumType.STRING)
    private Confirmation needFreeText = Confirmation.NO;

    @ManyToOne
    @JoinColumn(name = "l2id",nullable = false)
    @JsonBackReference
    private ClLevel2 clLevel2;

    @OneToMany(mappedBy = "clLevel3")
    @JsonManagedReference
    private Collection<ClLevel4> clLevel4s;

    @ManyToMany
    @JoinTable(name = "cl_level3_clinic",
            joinColumns = {@JoinColumn(name = "l3id")},
            inverseJoinColumns = {@JoinColumn(name = "departmentTypeId")})
    private Set<DepartmentType> clinicTypeSet = new HashSet<>();

//    @Embedded
//    private CommonFields commonFields;

    public int getL3id() {
        return l3id;
    }

    public void setL3id(int l3id) {
        this.l3id = l3id;
    }

    public String getDuid() {
        return duid;
    }

    public void setDuid(String duid) {
        this.duid = duid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Confirmation getNeedFreeText() {
        return needFreeText;
    }

    public void setNeedFreeText(Confirmation needFreeText) {
        this.needFreeText = needFreeText;
    }

    public ClLevel2 getClLevel2() {
        return clLevel2;
    }

    public void setClLevel2(ClLevel2 clLevel2) {
        this.clLevel2 = clLevel2;
    }

    public Collection<ClLevel4> getClLevel4s() {
        return clLevel4s;
    }

    public void setClLevel4s(Collection<ClLevel4> clLevel4s) {
        this.clLevel4s = clLevel4s;
    }

    public Set<DepartmentType> getClinicTypeSet() {
        return clinicTypeSet;
    }

    public void setClinicTypeSet(Set<DepartmentType> clinicTypeSet) {
        this.clinicTypeSet = clinicTypeSet;
    }

    //    public CommonFields getCommonFields() {
//        return commonFields;
//    }
//
//    public void setCommonFields(CommonFields commonFields) {
//        this.commonFields = commonFields;
//    }
}
