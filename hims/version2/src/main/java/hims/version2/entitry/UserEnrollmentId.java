package hims.version2.entitry;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserEnrollmentId implements Serializable{

    @Column(columnDefinition = "CHAR(10)")
    private String userId;

    @Column(columnDefinition = "CHAR(10)")
    private String roleId;

    @Column(columnDefinition = "CHAR(10)")
    private String departmentCode;

    @Column(columnDefinition = "CHAR(10)")
    private String unitCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;
        if(!(obj instanceof UserEnrollmentId)) return false;

        UserEnrollmentId pk = (UserEnrollmentId)obj;

        return Objects.equals(getUserId(),pk.getUserId()) &&
                Objects.equals(getRoleId(),pk.getRoleId()) &&
                Objects.equals(getDepartmentCode(),pk.getDepartmentCode()) &&
                Objects.equals(getUnitCode(),pk.getUnitCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(),getRoleId(),getDepartmentCode(),getUnitCode());
    }



}
