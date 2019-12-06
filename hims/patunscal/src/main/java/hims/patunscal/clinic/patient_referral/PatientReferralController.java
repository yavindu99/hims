package hims.patunscal.clinic.patient_referral;

import hims.common.CustomResponse;
import hims.common.CustomResponseMainBody;
import hims.common.ResponseFinalize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/patunscal/patientReferral")
public class PatientReferralController {

    private PatientReferralServiceInt service;
    private ResponseFinalize rf;

    @Autowired
    public PatientReferralController(PatientReferralServiceInt service, ResponseFinalize rf) {
        this.service = service;
        this.rf = rf;
    }

    @PostMapping("/add")
    public ResponseEntity<CustomResponse> add(@RequestBody PatientReferral referral,
                                              @RequestHeader Map<String, String> header){

        CustomResponseMainBody mainBody = service.add(referral);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @PutMapping("/edit")
    public ResponseEntity<CustomResponse> edit(@RequestBody PatientReferral referral,
                                               @RequestHeader Map<String, String> header){

        CustomResponseMainBody mainBody = service.edit(referral);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @GetMapping("/getByObjectId/{objectId}")
    public ResponseEntity<CustomResponse> getByObjectId(@PathVariable(name = "objectId") String objectId,
                                                        @RequestHeader Map<String, String> header){

        CustomResponseMainBody mainBody = service.getByObjectId(objectId);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @DeleteMapping("/deleteByObjectId/{objectId}")
    public ResponseEntity<CustomResponse> deleteByObjectId(@PathVariable(name = "objectId") String objectId,
                                                           @RequestHeader Map<String, String> header){

        CustomResponseMainBody mainBody = service.deleteByObjectId(objectId);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }


}
