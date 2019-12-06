package hims.version2.service;

import hims.common.ClientMessages;
import hims.common.CustomResponseMainBody;
import hims.version2.dao.DepartmentDAOInt;
import hims.version2.dao.UserEnrollmentDAOInt;
import hims.version2.entitry.Department;
import hims.version2.entitry.UserEnrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserEnrollmentServiceImpl implements UserEnrollmentServiceInt {


    private UserEnrollmentDAOInt dao;

    @Autowired @Qualifier("Version2DepartmentDAOImpl")
    private DepartmentDAOInt departmentDAOInt;

    private HttpStatus httpStatusCode;
    private String msgCode;
    private String msg;

    @Autowired
    public UserEnrollmentServiceImpl(UserEnrollmentDAOInt dao) {
        this.dao = dao;
    }

    @Override
    public CustomResponseMainBody getClinicListByUsername(String username) {

        List<UserEnrollment> userEnrollmentList = dao.getListByUsername(username);
        List<Department> departmentList = new ArrayList<>();

        if (userEnrollmentList.size() == 0) {

            this.httpStatusCode = HttpStatus.BAD_REQUEST;
            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
            this.msg = "version2_no_enrolled_clinics_found_by_given_username";

        } else {

            userEnrollmentList.forEach(userEnrollment -> {

                String departmentCode = userEnrollment.getPk().getDepartmentCode();

                Department department = departmentDAOInt.getByDepartmentCode(departmentCode);

                if(Objects.nonNull(department)){

                    departmentList.add(department);

                }

            });

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
            this.msg = "version2_enrolled_clinic_list_found";
        }

        CustomResponseMainBody<List<Department>> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, departmentList);

        return mainBody;
    }
}
