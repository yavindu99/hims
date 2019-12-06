//package hims.login.version2.hims.version2.repository;
//
//import hims.login.version2.entity.DashboardAssignment;
//import hims.login.version2.entity.UserEnrollment;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//@RunWith(SpringRunner.class)
//@ComponentScan(basePackages = {"hims.common", "hims.version1"})
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class UserEnrollmentRepositoryTest {
//
//    @Autowired
//    private UserEnrollmentRepository repo;
//
//    @Autowired
//    private DashboardAssignmentRepository dRepo;
//
//    @Test
//    public void findUserEnrollmentsByUser_UserId() {
//
//        List<UserEnrollment>userEnrollmentList = repo.findUserEnrollmentsByUser_UserId("gendoc");
//        UserEnrollment userEnrollment = userEnrollmentList.get(0);
//
//        //assertEquals("Genetic OPD Doctor",userEnrollmentList.get(0).getRole().getRoleName());
//
//        DashboardAssignment dashboardAssignment = dRepo.
//                findDashboardAssignmentsByRole_RoleIdAndAndDepartment_DepartmentCodeAndUnit_UnitCode(
//                        userEnrollment.getRole().getRoleId(),
//                        userEnrollment.getDepartment().getDepartmentCode(),
//                        userEnrollment.getUnit().getUnitCode());
//
//        assertNotNull(dashboardAssignment);
//    }
//}