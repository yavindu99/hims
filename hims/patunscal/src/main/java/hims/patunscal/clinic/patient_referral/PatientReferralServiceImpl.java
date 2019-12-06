package hims.patunscal.clinic.patient_referral;

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
public class PatientReferralServiceImpl implements PatientReferralServiceInt{

    private PatientReferralDAOInt dao;
    private AuthenticationFacadeInt authenticationFacade;

    private HttpStatus httpStatusCode;
    private String msgCode;
    private String msg;

    @Autowired
    public PatientReferralServiceImpl(PatientReferralDAOInt dao, AuthenticationFacadeInt authenticationFacade) {
        this.dao = dao;
        this.authenticationFacade = authenticationFacade;
    }

    @Override
    public CustomResponseMainBody add(PatientReferral referral) {

        PatientReferral newReferral = null;

        UnsCommonFields commonFields = new UnsCommonFields();

        String username = authenticationFacade.getUsername();

        commonFields.setCreatedBy(username);
        commonFields.setLastUpdatedBy(username);


        try {

            referral.setCommonFields(commonFields);

            newReferral = dao.add(referral);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_patient_referral_successfully_added";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<PatientReferral> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newReferral);

        return mainBody;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public CustomResponseMainBody edit(PatientReferral referral) {

        PatientReferral newReferral = null;
        PatientReferral existingReferral = dao.getByObjectId(referral.getId());

        if(Objects.nonNull(existingReferral)){

            UnsCommonFields commonFields = new UnsCommonFields();

            String username = authenticationFacade.getUsername();

            commonFields.setLastUpdatedBy(username);

            commonFields.setCreatedOn(existingReferral.getCommonFields().getCreatedOn());
            commonFields.setCreatedBy(existingReferral.getCommonFields().getCreatedBy());

            referral.setCommonFields(commonFields);

            newReferral = dao.edit(referral);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_UPDATED.getMsgCode();
            this.msg = "cl_patient_referral_successfully_updated";

        }else{

            this.httpStatusCode = HttpStatus.BAD_REQUEST;
            this.msgCode = ClientMessages.FAILED_UPDATE.getMsgCode();
            this.msg = "cl_no_patient_history_found_by_given_object_id";

        }

        CustomResponseMainBody<PatientReferral> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newReferral);

        return mainBody;


    }

    @Override
    public CustomResponseMainBody getByObjectId(String id) {

        PatientReferral existingReferral = dao.getByObjectId(id);

        if(Objects.isNull(existingReferral)){

            this.httpStatusCode = HttpStatus.BAD_REQUEST;
            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
            this.msg = "cl_no_patient_referral_found_by_given_object_id";

        }else{

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
            this.msg = "cl_patient_referral_found";
        }

        CustomResponseMainBody<PatientReferral> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, existingReferral);

        return mainBody;

    }

    @Override
    public CustomResponseMainBody deleteByObjectId(String id) {

        PatientReferral existingReferral = dao.getByObjectId(id);

        if(Objects.isNull(existingReferral)){

            this.httpStatusCode = HttpStatus.BAD_REQUEST;
            this.msgCode = ClientMessages.FAILED_DELETE.getMsgCode();
            this.msg = "cl_no_patient_referral_found_by_given_object_id";


        }else{

            dao.deleteByObjectId(id);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_DELETED.getMsgCode();
            this.msg = "cl_patient_referral_successfully_deleted";
        }

        CustomResponseMainBody<PatientReferral> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, null);

        return mainBody;

    }


}
