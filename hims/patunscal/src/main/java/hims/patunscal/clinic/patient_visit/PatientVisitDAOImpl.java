package hims.patunscal.clinic.patient_visit;

import hims.common.ClientMessages;
import hims.common.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Objects;

@Repository
@Transactional
public class PatientVisitDAOImpl implements PatientVisitDAOInt {

    private PatientVisitRepository repo;

    @Autowired
    public PatientVisitDAOImpl(PatientVisitRepository repo) {
        this.repo = repo;
    }

    @Override
    public PatientVisit add(PatientVisit patientVisit)throws CustomException {

        return repo.save(patientVisit);
    }

    @Override
    public PatientVisit getByObjectId(String objectId) throws CustomException {

        PatientVisit visit = repo.findById(objectId).orElse(null);

        if(Objects.isNull(visit)){

            throw new CustomException(HttpStatus.NOT_FOUND, ClientMessages.NO_RECORDS_FOUND.getMsgCode(), "no_patient_visit_found_by_the_given_patient_visit_id");

        }

        return visit;

    }

}
