package hims.version1.controller;

import hims.common.CustomResponse;
import hims.common.CustomResponseMainBody;
import hims.common.ResponseFinalize;
import hims.version1.service.PatientServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/version1/patient")
public class PatientController {

    private PatientServiceInt service;
    private ResponseFinalize rf;

    @Autowired
    public PatientController(PatientServiceInt service, ResponseFinalize rf) {
        this.service = service;
        this.rf = rf;
    }

    @GetMapping("/getListBySearchCriteria")
    public ResponseEntity<CustomResponse> getListBySearchCriteria(
            Pageable pageable,
            @RequestParam(name = "patientLegalId") String patientLegalId,
            @RequestParam(name = "patientName") String patientName,
            @RequestParam(name = "patientAddressDistrict") String patientAddressDistrict,
            @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.getListBySearchCriteria(pageable,patientLegalId,patientName,patientAddressDistrict);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @GetMapping("/getByPatientId/{patientId}")
    public ResponseEntity<CustomResponse> getByPatientId(@PathVariable(name = "patientId") String patientId,
                                                             @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.getByPatientId(patientId);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

}
