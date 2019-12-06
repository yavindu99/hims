package hims.version1.dao;

import hims.common.ClientMessages;
import hims.common.CustomException;
import hims.version1.entity.Patient;
import hims.version1.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Objects;

@Repository
@Transactional
public class PatientDAOImpl implements PatientDAOInt {

    private PatientRepository repo;

    @Autowired
    public PatientDAOImpl(PatientRepository repo) {
        this.repo = repo;
    }

    @Override
    public Page<Patient> getListBySearchCriteria(Pageable pageable, String patientId) {

        return repo.findByPatientIdLike(pageable,patientId);

    }

    @Override
    public Patient getByPatientId(String patientId)throws CustomException {

        Patient patient = repo.findById(patientId).orElse(null);

        if (Objects.isNull(patient)) {

            throw new CustomException(HttpStatus.NOT_FOUND, ClientMessages.NO_RECORDS_FOUND.getMsgCode(), "no_version1_patient_found_by_the_given_data_patient_id");

        }

        return patient;

    }
}
