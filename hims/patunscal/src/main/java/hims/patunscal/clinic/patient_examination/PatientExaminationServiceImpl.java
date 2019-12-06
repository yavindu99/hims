package hims.patunscal.clinic.patient_examination;

import hims.common.ClientMessages;
import hims.common.CustomException;
import hims.common.CustomResponseMainBody;
import hims.patunscal.UnsCommonFields;
import hims.patunscal.clinic.patient_examination.abdomen_examination.PatientAbdomenExamination;
import hims.patunscal.clinic.patient_examination.abdomen_examination.PatientAbdomenExaminationDAOInt;
import hims.patunscal.clinic.patient_examination.cardiovascular_examination.PatientCardiovascularExamination;
import hims.patunscal.clinic.patient_examination.cardiovascular_examination.PatientCardiovascularExaminationDAOInt;
import hims.patunscal.clinic.patient_examination.general_examination.PatientGeneralExamination;
import hims.patunscal.clinic.patient_examination.general_examination.PatientGeneralExaminationDAOInt;
import hims.patunscal.clinic.patient_visit.PatientVisitDAOInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
public class PatientExaminationServiceImpl implements  PatientExaminationServiceInt{

    private HttpStatus httpStatusCode;
    private String msgCode;
    private String msg;

    @Autowired
    private PatientVisitDAOInt visitDAO;

    @Autowired
    private PatientGeneralExaminationDAOInt generalExaminationDAO;

    @Autowired
    private PatientAbdomenExaminationDAOInt abdomenExaminationDAO;

    @Autowired
    private PatientCardiovascularExaminationDAOInt cardiovascularExaminationDAO;

    @Override
    @Transactional
    public CustomResponseMainBody add(PatientExamination patientExamination) {

        String visitId = patientExamination.getVisitId();
        UnsCommonFields commonFields = new UnsCommonFields();

        PatientGeneralExamination generalExamination = patientExamination.getGeneralExamination();
        PatientAbdomenExamination abdomenExamination = patientExamination.getAbdomenExamination();
        PatientCardiovascularExamination cardiovascularExamination = patientExamination.getCardiovascularExamination();

        PatientExamination newPatientExamination = new PatientExamination();

        boolean isReceived = false;

        try {

            if(Objects.nonNull(generalExamination)){

                generalExamination.setVisitId(visitId);
                generalExamination.setCommonFields(commonFields);

                PatientGeneralExamination newPatientGeneralExamination  = generalExaminationDAO.add(generalExamination);
                newPatientExamination.setGeneralExamination(newPatientGeneralExamination);

                isReceived = true;

            }

            if(Objects.nonNull(abdomenExamination)){

                abdomenExamination.setVisitId(visitId);
                generalExamination.setCommonFields(commonFields);

                PatientAbdomenExamination newPatientAbdomenExamination  = abdomenExaminationDAO.add(abdomenExamination);
                newPatientExamination.setAbdomenExamination(newPatientAbdomenExamination);

                isReceived = true;

            }

            if(Objects.nonNull(cardiovascularExamination)){

                cardiovascularExamination.setVisitId(visitId);
                cardiovascularExamination.setCommonFields(commonFields);

                PatientCardiovascularExamination newCardiovascularExamination1  = cardiovascularExaminationDAO.add(cardiovascularExamination);
                newPatientExamination.setCardiovascularExamination(newCardiovascularExamination1);

                isReceived = true;

            }

            if(isReceived) {

                newPatientExamination.setVisitId(visitId);

                this.httpStatusCode = HttpStatus.OK;
                this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
                this.msg = "cl_patient_examination_successfully_added";

            }else {

                this.httpStatusCode = HttpStatus.BAD_REQUEST;
                this.msgCode = ClientMessages.FAILED_ADD.getMsgCode();
                this.msg = "cl_zero_patient_examination_received";
            }

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<PatientExamination> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newPatientExamination);

        return mainBody;
    }

    @Override
    @Transactional
    public CustomResponseMainBody edit(PatientExamination patientExamination) {

        String visitId = patientExamination.getVisitId();
        UnsCommonFields commonFields = new UnsCommonFields();

        PatientGeneralExamination generalExamination = patientExamination.getGeneralExamination();
        PatientAbdomenExamination abdomenExamination = patientExamination.getAbdomenExamination();
        PatientCardiovascularExamination cardiovascularExamination = patientExamination.getCardiovascularExamination();

        PatientExamination newPatientExamination = new PatientExamination();

        PatientGeneralExamination existingGeneralExamination = generalExaminationDAO.getByVisitId(visitId);
        PatientAbdomenExamination existingAbdomenExamination = abdomenExaminationDAO.getByVisitId(visitId);
        PatientCardiovascularExamination existingCardiovascularExamination = cardiovascularExaminationDAO.getByVisitId(visitId);

        boolean isReceived = false;

        try {

            if(Objects.nonNull(generalExamination)){

                generalExamination.setId(existingGeneralExamination.getId());

                generalExamination.setVisitId(visitId);

                commonFields.setCreatedOn(existingGeneralExamination.getCommonFields().getCreatedOn());
                commonFields.setCreatedBy(existingGeneralExamination.getCommonFields().getCreatedBy());
                generalExamination.setCommonFields(commonFields);


                PatientGeneralExamination newPatientGeneralExamination  = generalExaminationDAO.add(generalExamination);
                newPatientExamination.setGeneralExamination(newPatientGeneralExamination);

                isReceived = true;

            }

            if(Objects.nonNull(abdomenExamination)){

                abdomenExamination.setId(existingAbdomenExamination.getId());

                abdomenExamination.setVisitId(visitId);

                commonFields.setCreatedOn(existingAbdomenExamination.getCommonFields().getCreatedOn());
                commonFields.setCreatedBy(existingAbdomenExamination.getCommonFields().getCreatedBy());
                generalExamination.setCommonFields(commonFields);

                PatientAbdomenExamination newPatientAbdomenExamination  = abdomenExaminationDAO.add(abdomenExamination);
                newPatientExamination.setAbdomenExamination(newPatientAbdomenExamination);

                isReceived = true;

            }

            if(Objects.nonNull(cardiovascularExamination)){

                cardiovascularExamination.setId(existingCardiovascularExamination.getId());

                cardiovascularExamination.setVisitId(visitId);

                commonFields.setCreatedOn(existingCardiovascularExamination.getCommonFields().getCreatedOn());
                commonFields.setCreatedBy(existingCardiovascularExamination.getCommonFields().getCreatedBy());
                cardiovascularExamination.setCommonFields(commonFields);

                PatientCardiovascularExamination newCardiovascularExamination1  = cardiovascularExaminationDAO.add(cardiovascularExamination);
                newPatientExamination.setCardiovascularExamination(newCardiovascularExamination1);

                isReceived = true;

            }

            if(isReceived) {

                newPatientExamination.setVisitId(visitId);

                this.httpStatusCode = HttpStatus.OK;
                this.msgCode = ClientMessages.SUCCESSFULLY_UPDATED.getMsgCode();
                this.msg = "cl_patient_examination_successfully_updated";

            }else {

                this.httpStatusCode = HttpStatus.BAD_REQUEST;
                this.msgCode = ClientMessages.FAILED_UPDATE.getMsgCode();
                this.msg = "cl_zero_patient_examination_received";
            }

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<PatientExamination> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newPatientExamination);

        return mainBody;
    }

    @Override
    public CustomResponseMainBody getByVisitId(String visitId) {

        PatientExamination examination = new PatientExamination();

        examination.setVisitId(visitId);

        try {

            visitDAO.getByObjectId(visitId);

            PatientGeneralExamination generalExamination = generalExaminationDAO.getByVisitId(visitId);
            PatientAbdomenExamination abdomenExamination = abdomenExaminationDAO.getByVisitId(visitId);
            PatientCardiovascularExamination cardiovascularExamination = cardiovascularExaminationDAO.getByVisitId(visitId);

            examination.setGeneralExamination(generalExamination);
            examination.setAbdomenExamination(abdomenExamination);
            examination.setCardiovascularExamination(cardiovascularExamination);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
            this.msg = "cl_patient_examination_found";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();
        }

        CustomResponseMainBody<PatientExamination> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, examination);

        return mainBody;
    }

    @Override
    @Transactional
    public CustomResponseMainBody deleteByVisitId(String visitId) {

        PatientGeneralExamination existingGeneralExamination = generalExaminationDAO.getByVisitId(visitId);
        PatientAbdomenExamination existingAbdomenExamination = abdomenExaminationDAO.getByVisitId(visitId);
        PatientCardiovascularExamination existingCardiovascularExamination = cardiovascularExaminationDAO.getByVisitId(visitId);

        boolean isExisting = false;

        if(Objects.nonNull(existingGeneralExamination)){

            generalExaminationDAO.deleteByObjectId(existingGeneralExamination.getId());

            isExisting = true;

        }

        if(Objects.nonNull(existingAbdomenExamination)){

            abdomenExaminationDAO.deleteByObjectId(existingAbdomenExamination.getId());

            isExisting = true;

        }

        if(Objects.nonNull(existingCardiovascularExamination)){

            cardiovascularExaminationDAO.deleteByObjectId(existingCardiovascularExamination.getId());

            isExisting = true;

        }

        if(isExisting) {

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_DELETED.getMsgCode();
            this.msg = "cl_patient_examination_successfully_deleted";

        }else {

            this.httpStatusCode = HttpStatus.BAD_REQUEST;
            this.msgCode = ClientMessages.FAILED_DELETE.getMsgCode();
            this.msg = "no_cl_patient_examination_found";
        }


        CustomResponseMainBody<PatientExamination> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, null);

        return mainBody;
    }
}
