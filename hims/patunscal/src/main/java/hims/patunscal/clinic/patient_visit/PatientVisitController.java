package hims.patunscal.clinic.patient_visit;

import hims.common.CustomResponse;
import hims.common.CustomResponseMainBody;
import hims.common.ResponseFinalize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/patunscal/patientVisit")
public class PatientVisitController {

    private PatientVisitServiceInt service;
    private ResponseFinalize rf;

    @Autowired
    public PatientVisitController(PatientVisitServiceInt service,ResponseFinalize rf) {
        this.service = service;
        this.rf = rf;
    }

    @PostMapping("/add")
    public ResponseEntity<CustomResponse> add(@RequestBody PatientVisit patientVisit,
                                              @RequestHeader Map<String, String> header){

        CustomResponseMainBody mainBody = service.add(patientVisit);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

}
