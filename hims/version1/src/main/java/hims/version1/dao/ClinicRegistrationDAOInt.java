package hims.version1.dao;

import hims.common.CustomException;
import hims.version1.entity.ClinicRegistration;
import hims.version1.entity.Patient;

public interface ClinicRegistrationDAOInt {

    ClinicRegistration getByPatientAndDepartmentCode(String patientId, String departmentCode) throws CustomException;

}
