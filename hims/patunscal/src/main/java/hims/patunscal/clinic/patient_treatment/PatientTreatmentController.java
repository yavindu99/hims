package hims.patunscal.clinic.patient_treatment;

import hims.common.CustomResponse;
import hims.common.CustomResponseMainBody;
import hims.common.ResponseFinalize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/patunscal/patientTreatment")
public class PatientTreatmentController {

    private PatientTreatmentServiceInt service;
    private ResponseFinalize rf;

    @Autowired
    public PatientTreatmentController(PatientTreatmentServiceInt service, ResponseFinalize rf) {
        this.service = service;
        this.rf = rf;
    }

    @PostMapping("/add")
    public ResponseEntity<CustomResponse> add(@RequestBody PatientTreatment treatment,
                                              @RequestHeader Map<String, String> header){

        CustomResponseMainBody mainBody = service.add(treatment);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @PutMapping("/edit")
    public ResponseEntity<CustomResponse> edit(@RequestBody PatientTreatment treatment,
                                               @RequestHeader Map<String, String> header){

        CustomResponseMainBody mainBody = service.edit(treatment);

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
