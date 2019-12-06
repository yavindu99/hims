package hims.patunscal.clinic.patient_lab_investigation;

import hims.common.AuthenticationFacadeInt;
import hims.common.ClientMessages;
import hims.common.CustomException;
import hims.common.CustomResponseMainBody;
import hims.patunscal.UnsCommonFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PatientLabInvestigationServiceImpl implements PatientLabInvestigationServiceInt{

    private PatientLabInvestigationDAOInt dao;
    private AuthenticationFacadeInt authenticationFacade;

    private HttpStatus httpStatusCode;
    private String msgCode;
    private String msg;

    @Autowired
    public PatientLabInvestigationServiceImpl(PatientLabInvestigationDAOInt dao, AuthenticationFacadeInt authenticationFacade) {
        this.dao = dao;
        this.authenticationFacade = authenticationFacade;
    }

    @Override
    public CustomResponseMainBody add(PatientLabInvestigation investigation) {

        PatientLabInvestigation newInvestigation = null;

        UnsCommonFields commonFields = new UnsCommonFields();

        String username = authenticationFacade.getUsername();

        commonFields.setCreatedBy(username);
        commonFields.setLastUpdatedBy(username);


        try {

            investigation.setCommonFields(commonFields);

            newInvestigation = dao.add(investigation);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_patient_lab_investigation_successfully_added";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<PatientLabInvestigation> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newInvestigation);

        return mainBody;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public CustomResponseMainBody edit(PatientLabInvestigation investigation) {

        PatientLabInvestigation newInvestigation = null;
        PatientLabInvestigation existingLabInvestigation = dao.getByObjectId(investigation.getId());

        if(Objects.nonNull(existingLabInvestigation)){

            UnsCommonFields commonFields = new UnsCommonFields();

            String username = authenticationFacade.getUsername();

            commonFields.setLastUpdatedBy(username);

            commonFields.setCreatedOn(existingLabInvestigation.getCommonFields().getCreatedOn());
            commonFields.setCreatedBy(existingLabInvestigation.getCommonFields().getCreatedBy());

            investigation.setCommonFields(commonFields);

            newInvestigation = dao.edit(investigation);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_UPDATED.getMsgCode();
            this.msg = "cl_patient_lab_investigation_successfully_updated";

        }else{

            this.httpStatusCode = HttpStatus.BAD_REQUEST;
            this.msgCode = ClientMessages.FAILED_UPDATE.getMsgCode();
            this.msg = "cl_no_patient_lab_investigation_found_by_given_object_id";

        }

        CustomResponseMainBody<PatientLabInvestigation> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newInvestigation);

        return mainBody;


    }

    @Override
    public CustomResponseMainBody getByObjectId(String id) {

        PatientLabInvestigation existingLabInvestigation = dao.getByObjectId(id);

        if(Objects.isNull(existingLabInvestigation)){

            this.httpStatusCode = HttpStatus.BAD_REQUEST;
            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
            this.msg = "cl_no_patient_lab_investigation_found_by_given_object_id";

        }else{

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
            this.msg = "cl_patient_lab_investigation_found";
        }

        CustomResponseMainBody<PatientLabInvestigation> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, existingLabInvestigation);

        return mainBody;

    }

    @Override
    public CustomResponseMainBody deleteByObjectId(String id) {

        PatientLabInvestigation existingLabInvestigation = dao.getByObjectId(id);

        if(Objects.isNull(existingLabInvestigation)){

            this.httpStatusCode = HttpStatus.BAD_REQUEST;
            this.msgCode = ClientMessages.FAILED_DELETE.getMsgCode();
            this.msg = "cl_no_patient_lab_investigation_found_by_given_object_id";


        }else{

            dao.deleteByObjectId(id);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_DELETED.getMsgCode();
            this.msg = "cl_patient_lab_investigation_successfully_deleted";
        }

        CustomResponseMainBody<PatientLabInvestigation> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, null);

        return mainBody;

    }
}
