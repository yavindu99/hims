package hims.version2.service;

import hims.common.CustomResponseMainBody;

public interface UserEnrollmentServiceInt  {

    CustomResponseMainBody getClinicListByUsername(String username);


}
