package hims.version2.entitry;

import javax.persistence.*;

@Entity
@Table(name = "user_role_unit_dep")
public class UserEnrollment {


    @EmbeddedId
    private UserEnrollmentId pk;

    @ManyToOne
    @JoinColumn(name="userId",insertable = false,updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="roleId",insertable = false,updatable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name="unitCode",insertable = false,updatable = false)
    private Unit unit;

    @ManyToOne
    @JoinColumn(name="departmentCode",insertable = false,updatable = false)
    private Department department;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public UserEnrollmentId getPk() {
        return pk;
    }

    public void setPk(UserEnrollmentId pk) {
        this.pk = pk;
    }
}
