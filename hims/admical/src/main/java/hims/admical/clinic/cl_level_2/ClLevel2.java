package hims.admical.clinic.cl_level_2;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import hims.admical.administrative.department.departmentType.DepartmentType;
import hims.admical.clinic.cl_level_1.ClLevel1;
import hims.admical.clinic.cl_level_3.ClLevel3;
import hims.common.Confirmation;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cl_level_2")
public class ClLevel2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int l2id;

    @Column(unique = true)
    @Size(max = 255, message = "level_2_option_developer_unique_id_exceeds_max_length_of_255")
    private String duid;

    @Column(nullable = false, unique = true)
    @NotNull(message = "level_2_option_name_is_required")
    @NotEmpty(message = "level_2_option_name_cannot_be_empty")
    @Size(max = 255, message = "level_2_option_name_exceeds_max_length_of_255")
    private String name;

    @Size(max = 255, message = "level_2_option_description_exceeds_max_length_of_255")
    private String description;

    @Enumerated(EnumType.STRING)
    private Confirmation needFreeText = Confirmation.NO;

    @ManyToOne
    @JoinColumn(name = "l1id",nullable = false)
    @JsonBackReference
    private ClLevel1 clLevel1;

    @OneToMany(mappedBy = "clLevel2")
    @JsonManagedReference
    private Collection<ClLevel3> clLevel3s;

    @ManyToMany
    @JoinTable(name = "cl_level2_clinic",
            joinColumns = {@JoinColumn(name = "l2id")},
            inverseJoinColumns = {@JoinColumn(name = "departmentTypeId")})
    private Set<DepartmentType> clinicTypeSet = new HashSet<>();


//    @Embedded
//    private CommonFields commonFields;

    public int getL2id() {
        return l2id;
    }

    public void setL2id(int l2id) {
        this.l2id = l2id;
    }

    public String getDuid() {
        return duid;
    }


    public void setDuid(String duid) {
        this.duid = duid;
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

    public ClLevel1 getClLevel1() {
        return clLevel1;
    }

    public void setClLevel1(ClLevel1 clLevel1) {
        this.clLevel1 = clLevel1;
    }

    public Collection<ClLevel3> getClLevel3s() {
        return clLevel3s;
    }

    public void setClLevel3s(Collection<ClLevel3> clLevel3s) {
        this.clLevel3s = clLevel3s;
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



