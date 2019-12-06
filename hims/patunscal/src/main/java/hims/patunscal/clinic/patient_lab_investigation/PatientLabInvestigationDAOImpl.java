package hims.patunscal.clinic.patient_lab_investigation;

import hims.common.ClientMessages;
import hims.common.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public class PatientLabInvestigationDAOImpl implements PatientLabInvestigationDAOInt {

  private PatientLabInvestigationRepository repo;

  @Autowired
  public PatientLabInvestigationDAOImpl(PatientLabInvestigationRepository repo) {
    this.repo = repo;
  }

  @Override
  public PatientLabInvestigation add(PatientLabInvestigation investigation) throws CustomException {

    PatientLabInvestigation newInvestigation;

    try {

      newInvestigation = repo.save(investigation);

    } catch (DuplicateKeyException ex) {

      throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "cl_patient_visit_id_is_already_exists");

    }

    return newInvestigation;
  }

  @Override
  public PatientLabInvestigation edit(PatientLabInvestigation investigation) {

    PatientLabInvestigation newInvestigation = repo.save(investigation);

    return newInvestigation;
  }

  @Override
  public PatientLabInvestigation getByObjectId(String id) {

    return repo.findById(id).orElse(null);

  }

  @Override
  public void deleteByObjectId(String id) {

    repo.deleteById(id);
  }
}
