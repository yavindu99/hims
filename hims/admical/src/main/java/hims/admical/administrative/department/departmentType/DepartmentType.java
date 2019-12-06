package hims.admical.administrative.department.departmentType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import hims.admical.administrative.department.Department;
import hims.admical.administrative.user.CommonFields;
import hims.admical.clinic.cl_level_1.ClLevel1;
import hims.admical.clinic.cl_level_2.ClLevel2;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "department_type")
public class DepartmentType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentTypeId;

    @Column(nullable = false,unique = true)
    @NotNull(message = "department_type_name_is_required")
    @NotEmpty(message = "department_type_name_must_not_be_empty")
    @Size(max = 255,message = "department_type_name_exceeds_max_length_of_255")
    private String departmentTypeName;

    @OneToMany(mappedBy = "departmentType")
    private List<Department> departmentList = new ArrayList<>();

//    @Embedded
//    private CommonFields commonFields;

    @ManyToMany(mappedBy = "clinicTypeSet")
    private Set<ClLevel1> clLevel1Set = new HashSet<>();


    public String getDepartmentTypeName() {
        return departmentTypeName;
    }

    public void setDepartmentTypeName(String departmentTypeName) {
        this.departmentTypeName = departmentTypeName;
    }

    public int getDepartmentTypeId() {
        return departmentTypeId;
    }

    public void setDepartmentTypeId(int departmentTypeId) {
        this.departmentTypeId = departmentTypeId;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

//    public CommonFields getCommonFields() {
//        return commonFields;
//    }
//
//    public void setCommonFields(CommonFields commonFields) {
//        this.commonFields = commonFields;
//    }

    public Set<ClLevel1> getClLevel1Set() {
        return clLevel1Set;
    }

    public void setClLevel1Set(Set<ClLevel1> clLevel1Set) {
        this.clLevel1Set = clLevel1Set;
    }

}
