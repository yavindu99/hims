package hims.admical.clinic.cl_level_4;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hims.admical.administrative.department.departmentType.DepartmentType;
import hims.admical.clinic.cl_level_3.ClLevel3;
import hims.common.Confirmation;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cl_level_4")
public class ClLevel4 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int l4id;

    @Column(nullable = false, unique = true)
    @Size(max = 255, message = "level_4_option_developer_unique_id_exceeds_max_length_of_255")
    private String duid;

    @Column(nullable = false, unique = true)
    @NotNull(message = "level_4_option_name_is_required")
    @NotEmpty(message = "level_4_option_name_cannot_be_empty")
    @Size(max = 255, message = "level_4_option_name_exceeds_max_length_of_255")
    private String name;

    @Size(max = 255, message = "level_4_option_description_exceeds_max_length_of_255")
    private String description;

    @Enumerated(EnumType.STRING)
    private Confirmation needFreeText = Confirmation.NO;

    @ManyToOne
    @JoinColumn(name = "l3id",nullable = false)
    @JsonBackReference
    private ClLevel3 clLevel3;

    @ManyToMany
    @JoinTable(name = "cl_level4_clinic",
            joinColumns = {@JoinColumn(name = "l4id")},
            inverseJoinColumns = {@JoinColumn(name = "departmentTypeId")})
    private Set<DepartmentType> clinicTypeSet = new HashSet<>();

//    @Embedded
//    private CommonFields commonFields;

    public int getL4id() {
        return l4id;
    }

    public void setL4id(int l4id) {
        this.l4id = l4id;
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

    public ClLevel3 getClLevel3() {
        return clLevel3;
    }

    public void setClLevel3(ClLevel3 clLevel3) {
        this.clLevel3 = clLevel3;
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
