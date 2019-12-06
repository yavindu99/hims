package hims.admical.administrative.unit;

import hims.admical.administrative.department.Department;
import hims.admical.administrative.user.CommonFields;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="unit")
public class Unit {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int unitId;

    @Column(nullable = false,unique = true)
    private String unitCode;

    @Column(nullable = false,unique = true)
    private String unitTitle;

    private String unitShortCode;

    @Embedded
    private CommonFields commonFields;

    @ManyToMany(mappedBy = "unitList")
    private Set<Department> departmentList = new HashSet<>();

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitTitle() {
        return unitTitle;
    }

    public void setUnitTitle(String unitTitle) {
        this.unitTitle = unitTitle;
    }

    public String getUnitShortCode() {
        return unitShortCode;
    }

    public void setUnitShortCode(String unitShortCode) {
        this.unitShortCode = unitShortCode;
    }

    public Set<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(Set<Department> departmentList) {
        this.departmentList = departmentList;
    }


}
