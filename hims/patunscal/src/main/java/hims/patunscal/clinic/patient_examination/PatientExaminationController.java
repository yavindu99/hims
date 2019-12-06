package hims.patunscal.clinic.patient_examination;

import hims.common.CustomResponse;
import hims.common.CustomResponseMainBody;
import hims.common.ResponseFinalize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/patunscal/patientExamination")
public class PatientExaminationController {

    private PatientExaminationServiceInt service;
    private ResponseFinalize rf;

    @Autowired
    public PatientExaminationController(PatientExaminationServiceInt service, ResponseFinalize rf) {
        this.service = service;
        this.rf = rf;
    }

    @PostMapping("/add")
    public ResponseEntity<CustomResponse> add(@Valid @RequestBody PatientExamination patientExamination, @RequestHeader Map<String, String> header){

        CustomResponseMainBody mainBody = service.add(patientExamination);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @PutMapping("/edit")
    public ResponseEntity<CustomResponse> edit(@Valid @RequestBody PatientExamination patientExamination, @RequestHeader Map<String, String> header){

        CustomResponseMainBody mainBody = service.edit(patientExamination);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @GetMapping("/getByVisitId/{visitId}")
    public ResponseEntity<CustomResponse> getByVisitId(@PathVariable(name = "visitId") String visitId, @RequestHeader Map<String, String> header){

        CustomResponseMainBody mainBody = service.getByVisitId(visitId);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @DeleteMapping("/deleteByVisitId/{visitId}")
    public ResponseEntity<CustomResponse> deleteByVisitId(@PathVariable(name = "visitId") String visitId, @RequestHeader Map<String, String> header){

        CustomResponseMainBody mainBody = service.deleteByVisitId(visitId);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }
}
