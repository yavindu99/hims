package hims.patunscal.clinic.patient_treatment;

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
public class PatientTreatmentServiceImpl implements PatientTreatmentServiceInt{

    private PatientTreatmentDAOInt dao;
    private AuthenticationFacadeInt authenticationFacade;

    private HttpStatus httpStatusCode;
    private String msgCode;
    private String msg;

    @Autowired
    public PatientTreatmentServiceImpl(PatientTreatmentDAOInt dao, AuthenticationFacadeInt authenticationFacade) {
        this.dao = dao;
        this.authenticationFacade = authenticationFacade;
    }

    @Override
    public CustomResponseMainBody add(PatientTreatment treatment) {

        PatientTreatment newTreatment = null;

        UnsCommonFields commonFields = new UnsCommonFields();

        String username = authenticationFacade.getUsername();

        commonFields.setCreatedBy(username);
        commonFields.setLastUpdatedBy(username);


        try {

            treatment.setCommonFields(commonFields);

            newTreatment = dao.add(treatment);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_patient_treatment_successfully_added";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<PatientTreatment> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newTreatment);

        return mainBody;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public CustomResponseMainBody edit(PatientTreatment treatment) {

        PatientTreatment newTreatment = null;
        PatientTreatment existingTreatment = dao.getByObjectId(treatment.getId());

        if(Objects.nonNull(existingTreatment)){

            UnsCommonFields commonFields = new UnsCommonFields();

            String username = authenticationFacade.getUsername();

            commonFields.setLastUpdatedBy(username);

            commonFields.setCreatedOn(existingTreatment.getCommonFields().getCreatedOn());
            commonFields.setCreatedBy(existingTreatment.getCommonFields().getCreatedBy());

            treatment.setCommonFields(commonFields);

            newTreatment = dao.edit(treatment);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_UPDATED.getMsgCode();
            this.msg = "cl_patient_treatment_successfully_updated";

        }else{

            this.httpStatusCode = HttpStatus.BAD_REQUEST;
            this.msgCode = ClientMessages.FAILED_UPDATE.getMsgCode();
            this.msg = "cl_no_patient_history_found_by_given_object_id";

        }

        CustomResponseMainBody<PatientTreatment> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newTreatment);

        return mainBody;


    }

    @Override
    public CustomResponseMainBody getByObjectId(String id) {

        PatientTreatment existingTreatment = dao.getByObjectId(id);

        if(Objects.isNull(existingTreatment)){

            this.httpStatusCode = HttpStatus.BAD_REQUEST;
            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
            this.msg = "cl_no_patient_treatment_found_by_given_object_id";

        }else{

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
            this.msg = "cl_patient_treatment_found";
        }

        CustomResponseMainBody<PatientTreatment> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, existingTreatment);

        return mainBody;

    }

    @Override
    public CustomResponseMainBody deleteByObjectId(String id) {

        PatientTreatment existingTreatment = dao.getByObjectId(id);

        if(Objects.isNull(existingTreatment)){

            this.httpStatusCode = HttpStatus.BAD_REQUEST;
            this.msgCode = ClientMessages.FAILED_DELETE.getMsgCode();
            this.msg = "cl_no_patient_treatment_found_by_given_object_id";


        }else{

            dao.deleteByObjectId(id);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_DELETED.getMsgCode();
            this.msg = "cl_patient_treatment_successfully_deleted";
        }

        CustomResponseMainBody<PatientTreatment> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, null);

        return mainBody;

    }


}
