package hims.version1.controller;

import hims.common.CustomResponse;
import hims.common.CustomResponseMainBody;
import hims.common.ResponseFinalize;
import hims.version1.service.ClinicRegistrationServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("version1/clinic_registration")
public class ClinicRegistrationController {

    private ClinicRegistrationServiceInt service;
    private ResponseFinalize rf;

    @Autowired
    public ClinicRegistrationController(ClinicRegistrationServiceInt service, ResponseFinalize rf) {
        this.service = service;
        this.rf = rf;
    }

    @GetMapping("/getByPatientIdAndClinicDepartmentCode")
    public ResponseEntity<CustomResponse> getByPatientId(@RequestParam(name = "patientId") String patientId,
                                                         @RequestParam(name = "clinicDepartmentCode") String departmentCode,
                                                         @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.getByPatientIdAndDepartmentCode(patientId,departmentCode);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }


}
