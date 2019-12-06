package hims.admical.administrative.user;

import hims.admical.administrative.department.Department;
import hims.admical.administrative.role.Role;
import hims.admical.administrative.unit.Unit;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="user_enrollment")
public class UserEnrollment {

    @Embeddable
    private static class Pk implements Serializable{

        @Column(columnDefinition = "CHAR(10)")
        private String username;

        private int roleId;

        private int unitId;

        private int departmentId;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        public int getUnitId() {
            return unitId;
        }

        public void setUnitId(int unitId) {
            this.unitId = unitId;
        }

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        @Override
        public boolean equals(Object obj) {

            if(this == obj) return true;
            if(!(obj instanceof Pk)) return false;

            Pk pk = (Pk) obj;

            return Objects.equals(getUsername(),pk.getUsername()) &&
                    Objects.equals(getRoleId(),pk.getRoleId()) &&
                    Objects.equals(getDepartmentId(),pk.getDepartmentId()) &&
                    Objects.equals(getUnitId(),pk.getUnitId());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getUsername(),getRoleId(),getDepartmentId(),getUnitId());
        }
    }

    @EmbeddedId
    private Pk pk;

    @ManyToOne
    @JoinColumn(name="username",insertable = false,updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="roleId",insertable = false,updatable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name="unitId",insertable = false,updatable = false)
    private Unit unit;

    @ManyToOne
    @JoinColumn(name="departmentId",insertable = false,updatable = false)
    private Department department;

}

