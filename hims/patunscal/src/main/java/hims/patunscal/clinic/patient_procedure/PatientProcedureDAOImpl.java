package hims.patunscal.clinic.patient_procedure;

import com.mongodb.DuplicateKeyException;
import hims.common.ClientMessages;
import hims.common.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Transactional
@Repository
public class PatientProcedureDAOImpl implements PatientProcedureDAOInt {

  private PatientProcedureRepository repo;

  @Autowired
  public PatientProcedureDAOImpl(PatientProcedureRepository repo) {

    this.repo = repo;
  }

  @Override
  public PatientProcedure add(PatientProcedure procedure) throws CustomException {

    PatientProcedure newProcedure;

    try {

      newProcedure = repo.save(procedure);

    } catch (DuplicateKeyException ex) {

      throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "cl_patient_visit_id_is_already_exists");

    }

    return newProcedure;
  }

  @Override
  public PatientProcedure edit(PatientProcedure procedure) {

    PatientProcedure newProcedure = repo.save(procedure);
    return newProcedure;
  }

  @Override
  public PatientProcedure getByObjectId(String id) {
    return repo.findById(id).orElse(null);

  }

  @Override
  public void deleteByObjectId(String id) {

    repo.deleteById(id);

  }
}






