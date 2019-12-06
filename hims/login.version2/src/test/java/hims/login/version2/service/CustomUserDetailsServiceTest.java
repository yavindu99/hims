//package hims.login.version2.hims.version2.service;
//
//import hims.login.version2.entity.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@ComponentScan(basePackages = {"hims.common", "hims.version1"})
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class CustomUserDetailsServiceTest {
//
//    @Autowired
//    private CustomUserDetailsService hims.version2.service;
//
//    @Test
//    public void loadUserByUsername() {
//
//        User user = hims.version2.service.loadUserByUsername("admin");
//
//        assertEquals("Administrator Department",user.getDashboardAssignmentList().get(0).getDepartment().getDepartmentTitle());
//
//    }
//}