package hims.patunscal.clinic.patient_visit;

import hims.common.AuthenticationFacadeInt;
import hims.common.ClientMessages;
import hims.common.CustomException;
import hims.common.CustomResponseMainBody;

import hims.patunscal.UnsCommonFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PatientVisitServiceImpl implements PatientVisitServiceInt {

    @Autowired
    private AuthenticationFacadeInt authenticationFacade;

    private PatientVisitDAOInt dao;

    private HttpStatus httpStatusCode;
    private String msgCode;
    private String msg;

    @Autowired
    public PatientVisitServiceImpl(PatientVisitDAOInt dao) {
        this.dao = dao;
    }

    @Override
    public CustomResponseMainBody add(PatientVisit patientVisit) {

        PatientVisit newPatientVisit = null;
        UnsCommonFields commonFields = new UnsCommonFields();

        String username = authenticationFacade.getUsername();

        commonFields.setCreatedBy(username);
        commonFields.setLastUpdatedBy(username);

        try {

            patientVisit.setCommonFields(commonFields);
            newPatientVisit = dao.add(patientVisit);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_patient_visit_successfully_added";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<PatientVisit> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newPatientVisit);

        return mainBody;
    }
}
