package hims.patunscal.clinic.patient_referral;

import hims.common.ClientMessages;
import hims.common.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class PatientReferralDAOImpl implements PatientReferralDAOInt {

    private PatientReferralRepository repo;

    @Autowired
    public PatientReferralDAOImpl(PatientReferralRepository repo) {
        this.repo = repo;
    }

    @Override
    public PatientReferral add(PatientReferral referral)throws CustomException {

        PatientReferral newReferral;

        try {

            newReferral = repo.save(referral);

        }catch (DuplicateKeyException ex){

            throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(), "cl_patient_visit_id_is_already_exists");

        }

        return newReferral;
    }

    @Override
    public PatientReferral edit(PatientReferral referral) {

        PatientReferral newReferral = repo.save(referral);

        return newReferral;
    }

    @Override
    public PatientReferral getByObjectId(String id) {

        return repo.findById(id).orElse(null);

    }

    @Override
    public void deleteByObjectId(String id) {

        repo.deleteById(id);
    }

}
