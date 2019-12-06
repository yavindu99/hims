package hims.patunscal.clinic.patient_procedure;

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
public class PatientProcedureServiceImpl implements PatientProcedureServiceInt {

  private PatientProcedureDAOInt dao;
  private AuthenticationFacadeInt authenticationFacade;

  private HttpStatus httpStatusCode;
  private String msgCode;
  private String msg;

  @Autowired
  public PatientProcedureServiceImpl(PatientProcedureDAOInt dao, AuthenticationFacadeInt authenticationFacade) {
    this.dao = dao;
    this.authenticationFacade = authenticationFacade;
  }

  @Override
  public CustomResponseMainBody add(PatientProcedure procedure) {
    PatientProcedure newProcedure = null;
    UnsCommonFields commonFields = new UnsCommonFields();
    String username = authenticationFacade.getUsername();

    commonFields.setCreatedBy(username);
    commonFields.setLastUpdatedBy(username);

    try {

      procedure.setCommonFields(commonFields);
      newProcedure = dao.add(procedure);

      this.httpStatusCode = HttpStatus.OK;
      this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
      this.msg = "cl_patient_procedure_successfully_added";

    } catch (CustomException ex) {
      this.httpStatusCode = ex.getHttpStatus();
      this.msgCode = ex.getCode();
      this.msg = ex.getMsg()
      ;
    }

    CustomResponseMainBody<PatientProcedure> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newProcedure);

    return mainBody;

  }

  @Override
  public CustomResponseMainBody edit(PatientProcedure procedure) {

    PatientProcedure newProcedure = null;
    PatientProcedure existingProcedure = dao.getByObjectId(procedure.getId());

    if (Objects.nonNull(existingProcedure)) {

      UnsCommonFields commonFields = new UnsCommonFields();

      String username = authenticationFacade.getUsername();

      commonFields.setLastUpdatedBy(username);

      commonFields.setCreatedOn(existingProcedure.getCommonFields().getCreatedOn());
      commonFields.setCreatedBy(existingProcedure.getCommonFields().getCreatedBy());

      procedure.setCommonFields(commonFields);

      newProcedure = dao.edit(procedure);

      this.httpStatusCode = HttpStatus.OK;
      this.msgCode = ClientMessages.SUCCESSFULLY_UPDATED.getMsgCode();
      this.msg = "cl_patient_procedure_successfully_updated";

    } else {

      this.httpStatusCode = HttpStatus.BAD_REQUEST;
      this.msgCode = ClientMessages.FAILED_UPDATE.getMsgCode();
      this.msg = "cl_no_patient_procedure_found_by_given_object_id";
    }

    CustomResponseMainBody<PatientProcedure> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newProcedure);

    return mainBody;

  }

  @Override
  public CustomResponseMainBody getByObjectId(String id) {

    PatientProcedure existingProcedure = dao.getByObjectId(id);

    if (Objects.isNull(existingProcedure)) {

      this.httpStatusCode = HttpStatus.BAD_REQUEST;
      this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
      this.msg = "cl_no_patient_procedure_found_by_given_object_id";

    } else {

      this.httpStatusCode = HttpStatus.OK;
      this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
      this.msg = "cl_patient_procedure_found";
    }

    CustomResponseMainBody<PatientProcedure> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, existingProcedure);

    return mainBody;
  }

  @Override
  public CustomResponseMainBody deleteByObjectId(String id) {
    PatientProcedure existingProcedure = dao.getByObjectId(id);

    if (Objects.isNull(existingProcedure)) {

      this.httpStatusCode = HttpStatus.BAD_REQUEST;
      this.msgCode = ClientMessages.FAILED_DELETE.getMsgCode();
      this.msg = "cl_no_patient_procedure_found_by_given_object_id";


    } else {

      dao.deleteByObjectId(id);

      this.httpStatusCode = HttpStatus.OK;
      this.msgCode = ClientMessages.SUCCESSFULLY_DELETED.getMsgCode();
      this.msg = "cl_patient_procedure_successfully_deleted";
    }

    CustomResponseMainBody<PatientProcedure> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, null);

    return mainBody;
  }


}
