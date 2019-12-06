package hims.patunscal.clinic.patient_examination.general_examination;

import hims.common.ClientMessages;
import hims.common.CustomException;
import hims.common.CustomResponseMainBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PatientGeneralExaminationServiceImpl implements PatientGeneralExaminationServiceInt {

    private PatientGeneralExaminationDAOInt dao;

    private HttpStatus httpStatusCode;
    private String msgCode;
    private String msg;

    @Autowired
    public PatientGeneralExaminationServiceImpl(PatientGeneralExaminationDAOInt dao) {
        this.dao = dao;
    }

    @Override
    public CustomResponseMainBody add(PatientGeneralExamination patientGeneralExamination) {

        PatientGeneralExamination newPatientGeneralExamination = null;

        try {

            newPatientGeneralExamination = dao.add(patientGeneralExamination);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_patient_general_examination_successfully_added";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<PatientGeneralExamination> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newPatientGeneralExamination);

        return mainBody;
    }
}
