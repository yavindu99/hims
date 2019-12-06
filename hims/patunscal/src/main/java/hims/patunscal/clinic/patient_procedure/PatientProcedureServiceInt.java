package hims.patunscal.clinic.patient_procedure;

import hims.common.CustomResponseMainBody;

public interface PatientProcedureServiceInt {

  CustomResponseMainBody add(PatientProcedure procedure);

  CustomResponseMainBody edit(PatientProcedure procedure);

  CustomResponseMainBody getByObjectId(String id);

  CustomResponseMainBody deleteByObjectId(String id);
}
