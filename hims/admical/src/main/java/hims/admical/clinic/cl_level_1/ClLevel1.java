package hims.admical.clinic.cl_level_1;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import hims.admical.administrative.department.departmentType.DepartmentType;
import hims.admical.clinic.cl_level_2.ClLevel2;
import hims.common.Confirmation;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cl_level_1")
public class ClLevel1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int l1id;

    @Column(unique = true)
    @Size(max = 255, message = "level_1_option_developer_unique_id_exceeds_max_length_of_255")
    private String duid;

    @Column(nullable = false, unique = true)
    @NotNull(message = "level_1_option_name_is_required")
    @NotEmpty(message = "level_1_option_name_cannot_be_empty")
    @Size(max = 255, message = "level_1_option_name_exceeds_max_length_of_255")
    private String name;

    @Size(max = 255, message = "level_1_option_description_exceeds_max_length_of_255")
    private String description;

    @Enumerated(EnumType.STRING)
    private Confirmation needFreeText = Confirmation.NO;

    @OneToMany(mappedBy = "clLevel1")
    private List<ClLevel2> clLevel2List = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "cl_level1_clinic",
                joinColumns = {@JoinColumn(name = "l1id")},
                inverseJoinColumns = {@JoinColumn(name = "departmentTypeId")})
    private Set<DepartmentType> clinicTypeSet = new HashSet<>();
//
//    @Embedded
//    private CommonFields commonFields;

    public int getL1id() {
        return l1id;
    }

    public void setL1id(int l1id) {
        this.l1id = l1id;
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

    @JsonIgnore
    public List<ClLevel2> getClLevel2List() {
        return clLevel2List;
    }

    public void setClLevel2List(List<ClLevel2> clLevel2List) {
        this.clLevel2List = clLevel2List;
    }


    @JsonIgnore
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
