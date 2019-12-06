package hims.version1.dao;

import hims.common.CustomException;
import hims.version1.entity.ClinicRegistration;
import hims.version1.entity.Patient;
import hims.version1.repository.ClinicRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ClinicRegistrationDAOImpl implements ClinicRegistrationDAOInt{

    private ClinicRegistrationRepository repo;
    private PatientDAOInt dao;

    @Autowired
    public ClinicRegistrationDAOImpl(ClinicRegistrationRepository repo,PatientDAOInt dao) {
        this.repo = repo;
        this.dao = dao;
    }

    @Override
    public ClinicRegistration getByPatientAndDepartmentCode(String patientId, String departmentCode)throws CustomException {

        Patient patient = dao.getByPatientId(patientId);

        return repo.findByPatientAndDepartmentCode(patient,departmentCode);

    }
}
