package hims.version1.service;

import hims.common.ClientMessages;
import hims.common.CustomException;
import hims.common.CustomResponseMainBody;
import hims.version1.dao.ClinicRegistrationDAOInt;
import hims.version1.entity.ClinicRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ClinicRegistrationServiceImpl implements ClinicRegistrationServiceInt {

    private ClinicRegistrationDAOInt dao;

    private HttpStatus httpStatusCode;
    private String msgCode;
    private String msg;

    @Autowired
    public ClinicRegistrationServiceImpl(ClinicRegistrationDAOInt dao) {
        this.dao = dao;
    }

    @Override
    public CustomResponseMainBody getByPatientIdAndDepartmentCode(String patientId, String departmentCode) {

        ClinicRegistration clinicRegistration = null;

        try {

            clinicRegistration = dao.getByPatientAndDepartmentCode(patientId,departmentCode);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
            this.msg = "version1_clinic_registration_found";

        } catch (CustomException ex) {

            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
            this.msg = "no_version1_clinic_registration_found";
        }

        CustomResponseMainBody<ClinicRegistration> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, clinicRegistration);

        return mainBody;
    }
}
