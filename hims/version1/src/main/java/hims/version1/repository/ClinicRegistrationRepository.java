package hims.version1.repository;

import hims.version1.entity.ClinicRegistration;
import hims.version1.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRegistrationRepository extends JpaRepository<ClinicRegistration,Integer> {

    ClinicRegistration findByPatientAndDepartmentCode(Patient patient,String departmentCode);


}
