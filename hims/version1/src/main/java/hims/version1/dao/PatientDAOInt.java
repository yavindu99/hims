package hims.version1.dao;

import hims.common.CustomException;
import hims.version1.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PatientDAOInt {

    Page<Patient> getListBySearchCriteria(Pageable pageable, String patientId);
    Patient getByPatientId(String patientId)throws CustomException;

}
