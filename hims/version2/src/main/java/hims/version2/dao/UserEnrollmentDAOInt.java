package hims.version2.dao;

import hims.version2.entitry.UserEnrollment;

import java.util.List;

public interface UserEnrollmentDAOInt {

    List<UserEnrollment> getListByUsername(String username);


}
