package hims.version2.repository;

import hims.version2.entitry.DashboardAssignment;
import hims.version2.entitry.DashboardAssignmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface DashboardAssignmentRepository extends JpaRepository<DashboardAssignment, DashboardAssignmentId> {

	DashboardAssignment findDashboardAssignmentsByRole_RoleIdAndAndDepartment_DepartmentCodeAndUnit_UnitCode(String roleId, String departmentCode, String unitCode);

}
