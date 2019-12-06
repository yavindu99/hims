package hims.admical.administrative.mainDashboard;

import hims.admical.administrative.department.Department;
import hims.admical.administrative.role.Role;
import hims.admical.administrative.unit.Unit;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "dashboard_assignment")
public class DashboardAssignment {

    @EmbeddedId
    private Pk pk;
    @ManyToOne
    @JoinColumn(name = "mainDashboardId", insertable = false, updatable = false)
    private MainDashboard mainDashboard;
    @ManyToOne
    @JoinColumn(name = "unitId", insertable = false, updatable = false)
    private Unit unit;
    @ManyToOne
    @JoinColumn(name = "departmentId", insertable = false, updatable = false)
    private Department department;
    @ManyToOne
    @JoinColumn(name = "roleId", insertable = false, updatable = false)
    private Role role;

    @Embeddable
    private static class Pk implements Serializable {

        private String mainDashboardId;
        private int unitId;
        private int departmentId;
        private int roleId;


        public String getMainDashboardId() {
            return mainDashboardId;
        }

        public void setMainDashboardId(String mainDashboardId) {
            this.mainDashboardId = mainDashboardId;
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

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;
            if (!(obj instanceof Pk)) return false;

            Pk pk = (Pk) obj;

            return Objects.equals(getMainDashboardId(), pk.getMainDashboardId()) && Objects.equals(getDepartmentId(), pk.getDepartmentId()) && Objects.equals(getRoleId(), pk.getRoleId()) && Objects.equals(getUnitId(), pk.getUnitId());

        }

        @Override
        public int hashCode() {
            return Objects.hash(getMainDashboardId(),getDepartmentId(),getRoleId(),getUnitId());
        }
    }


}
