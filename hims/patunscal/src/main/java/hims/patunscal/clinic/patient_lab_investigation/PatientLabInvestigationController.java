package hims.patunscal.clinic.patient_lab_investigation;

import hims.common.CustomResponse;
import hims.common.CustomResponseMainBody;
import hims.common.ResponseFinalize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/patunscal/patientLabInvestigation")
public class PatientLabInvestigationController {

    private PatientLabInvestigationServiceInt service;
    private ResponseFinalize rf;

    @Autowired
    public PatientLabInvestigationController(PatientLabInvestigationServiceInt service,ResponseFinalize rf) {
        this.service = service;
        this.rf = rf;
    }

    @PostMapping("/add")
    public ResponseEntity<CustomResponse> add(@RequestBody PatientLabInvestigation investigation,
                                              @RequestHeader Map<String, String> header){

        CustomResponseMainBody mainBody = service.add(investigation);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @PutMapping("/edit")
    public ResponseEntity<CustomResponse> edit(@RequestBody PatientLabInvestigation investigation,
                                              @RequestHeader Map<String, String> header){

        CustomResponseMainBody mainBody = service.edit(investigation);

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
