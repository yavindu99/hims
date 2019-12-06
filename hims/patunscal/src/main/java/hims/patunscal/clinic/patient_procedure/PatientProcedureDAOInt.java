package hims.patunscal.clinic.patient_procedure;

import hims.common.CustomException;

public interface PatientProcedureDAOInt {
  PatientProcedure add(PatientProcedure procedure) throws CustomException;

  PatientProcedure edit(PatientProcedure procedure);

  PatientProcedure getByObjectId(String id);

  void deleteByObjectId(String id);
}
