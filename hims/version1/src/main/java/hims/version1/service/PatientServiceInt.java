package hims.version1.service;

import hims.common.CustomResponseMainBody;
import org.springframework.data.domain.Pageable;

public interface PatientServiceInt {

    CustomResponseMainBody getListBySearchCriteria(Pageable pageable,String patientLegalId,String patientName,String patientAddressDistrict);
    CustomResponseMainBody getByPatientId(String patientId);
}
