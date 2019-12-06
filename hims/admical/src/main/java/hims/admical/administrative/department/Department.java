package hims.admical.administrative.department;

import hims.admical.administrative.department.departmentType.DepartmentType;
import hims.admical.administrative.unit.Unit;
import hims.admical.administrative.user.CommonFields;
import hims.admical.clinic.cl_level_1.ClLevel1;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int departmentId;

    @Column(nullable = false,unique = true)
    @NotNull(message="Department code is required")
    @NotEmpty(message="Department code cannot be empty")
    @Size(max = 255)
    private String departmentCode;

    @Column(nullable = false,unique = true)
    @NotNull(message="Department name is required")
    @NotEmpty(message="Department name cannot be empty")
    @Size(max = 255)
    private String departmentName;

    @Size(max = 255)
    private String departmentShortCode;

    @ManyToOne
    @JoinColumn(name="departmentTypeName",referencedColumnName = "departmentTypeName",nullable = false,updatable = false,insertable = false)
    @NotNull
    private DepartmentType departmentType;

    @Embedded
    private CommonFields commonFields;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "unit_department",
            joinColumns = {@JoinColumn(name="departmentId",nullable=false,updatable=false)},
            inverseJoinColumns = {@JoinColumn(name="unitId",nullable=false,updatable=false)}
            )
    private Set<Unit> unitList = new HashSet<>();



    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentShortCode() {
        return departmentShortCode;
    }

    public void setDepartmentShortCode(String departmentShortCode) {
        this.departmentShortCode = departmentShortCode;
    }

    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(DepartmentType departmentType) {
        this.departmentType = departmentType;
    }

    public Set<Unit> getUnitList() {
        return unitList;
    }

    public void setUnitList(Set<Unit> unitList) {
        this.unitList = unitList;
    }
}
