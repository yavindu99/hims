package hims.version1.repository;

import hims.version1.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PatientRepository extends JpaRepository<Patient,String> {

    Page<Patient> findByPatientIdLike(Pageable pageable, String patientId);
}
