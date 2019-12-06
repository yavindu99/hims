package hims.patunscal.clinic.patient_history;

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
public class PatientHistoryServiceImpl implements PatientHistoryServiceInt{

    private PatientHistoryDAOInt dao;
    private AuthenticationFacadeInt authenticationFacade;

    private HttpStatus httpStatusCode;
    private String msgCode;
    private String msg;

    @Autowired
    public PatientHistoryServiceImpl(PatientHistoryDAOInt dao, AuthenticationFacadeInt authenticationFacade) {
        this.dao = dao;
        this.authenticationFacade = authenticationFacade;
    }

    @Override
    public CustomResponseMainBody add(PatientHistory history) {

        PatientHistory newHistory = null;

        UnsCommonFields commonFields = new UnsCommonFields();

        String username = authenticationFacade.getUsername();

        commonFields.setCreatedBy(username);
        commonFields.setLastUpdatedBy(username);


        try {

            history.setCommonFields(commonFields);

            newHistory = dao.add(history);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_patient_history_successfully_added";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<PatientHistory> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newHistory);

        return mainBody;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public CustomResponseMainBody edit(PatientHistory history) {

        PatientHistory newHistory = null;
        PatientHistory existingHistory = dao.getByObjectId(history.getId());

        if(Objects.nonNull(existingHistory)){

            UnsCommonFields commonFields = new UnsCommonFields();

            String username = authenticationFacade.getUsername();

            commonFields.setLastUpdatedBy(username);

            commonFields.setCreatedOn(existingHistory.getCommonFields().getCreatedOn());
            commonFields.setCreatedBy(existingHistory.getCommonFields().getCreatedBy());

            history.setCommonFields(commonFields);

            newHistory = dao.edit(history);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_UPDATED.getMsgCode();
            this.msg = "cl_patient_history_successfully_updated";

        }else{

            this.httpStatusCode = HttpStatus.BAD_REQUEST;
            this.msgCode = ClientMessages.FAILED_UPDATE.getMsgCode();
            this.msg = "cl_no_patient_history_found_by_given_object_id";

        }

        CustomResponseMainBody<PatientHistory> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newHistory);

        return mainBody;


    }

    @Override
    public CustomResponseMainBody getByObjectId(String id) {

        PatientHistory existingHistory = dao.getByObjectId(id);

        if(Objects.isNull(existingHistory)){

            this.httpStatusCode = HttpStatus.BAD_REQUEST;
            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
            this.msg = "cl_no_patient_history_found_by_given_object_id";

        }else{

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
            this.msg = "cl_patient_history_found";
        }

        CustomResponseMainBody<PatientHistory> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, existingHistory);

        return mainBody;

    }

    @Override
    public CustomResponseMainBody deleteByObjectId(String id) {

        PatientHistory existingHistory = dao.getByObjectId(id);

        if(Objects.isNull(existingHistory)){

            this.httpStatusCode = HttpStatus.BAD_REQUEST;
            this.msgCode = ClientMessages.FAILED_DELETE.getMsgCode();
            this.msg = "cl_no_patient_history_found_by_given_object_id";


        }else{

            dao.deleteByObjectId(id);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_DELETED.getMsgCode();
            this.msg = "cl_patient_history_successfully_deleted";
        }

        CustomResponseMainBody<PatientHistory> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, null);

        return mainBody;

    }


}
