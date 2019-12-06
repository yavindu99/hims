package hims.version2.entitry;

import javax.persistence.*;

@Entity
@Table(name = "fq_main_dashboard")
public class DashboardAssignment {

    @EmbeddedId
    private DashboardAssignmentId pk;

    @ManyToOne
    @JoinColumn(name="roleId",insertable = false,updatable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name="unitCode",insertable = false,updatable = false)
    private Unit unit;

    @ManyToOne
    @JoinColumn(name="departmentCode",insertable = false,updatable = false)
    private Department department;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public DashboardAssignmentId getPk() {
        return pk;
    }

    public void setPk(DashboardAssignmentId pk) {
        this.pk = pk;
    }

}
