package hims.version1.service;

import hims.common.CustomResponseMainBody;

public interface ClinicRegistrationServiceInt {

    CustomResponseMainBody getByPatientIdAndDepartmentCode(String patientId, String departmentCode);

}
