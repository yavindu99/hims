package hims.version2.entitry;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DashboardAssignmentId implements  Serializable {

    private String mainDashboardId;

    @Column(columnDefinition = "CHAR(10)")
    private String roleId;

    @Column(columnDefinition = "CHAR(10)")
    private String unitCode;

    @Column(columnDefinition = "CHAR(10)")
    private String departmentCode;

    public String getMainDashboardId() {
        return mainDashboardId;
    }

    public void setMainDashboardId(String mainDashboardId) {
        this.mainDashboardId = mainDashboardId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;
        if(!(obj instanceof DashboardAssignmentId)) return false;

        DashboardAssignmentId pk = (DashboardAssignmentId)obj;

        return Objects.equals(getMainDashboardId(),pk.getMainDashboardId()) &&
                Objects.equals(getRoleId(),pk.getRoleId()) &&
                Objects.equals(getDepartmentCode(),pk.getDepartmentCode()) &&
                Objects.equals(getUnitCode(),pk.getUnitCode());


    }

    @Override
    public int hashCode() {

        return Objects.hash(getMainDashboardId(),getRoleId(),getDepartmentCode(),getUnitCode());
    }


}
