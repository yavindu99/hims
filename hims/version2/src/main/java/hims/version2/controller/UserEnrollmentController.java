package hims.version2.controller;

import hims.common.CustomResponse;
import hims.common.CustomResponseMainBody;
import hims.common.ResponseFinalize;
import hims.version2.service.UserEnrollmentServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/version2/userEnrollment")
public class UserEnrollmentController {

    private UserEnrollmentServiceInt service;
    private ResponseFinalize rf;

    @Autowired
    public UserEnrollmentController(UserEnrollmentServiceInt service, ResponseFinalize rf) {
        this.service = service;
        this.rf = rf;
    }

    @GetMapping("clinics/{username}")
    public ResponseEntity<CustomResponse> getClinicListByUsername(
            @PathVariable(name = "username") String username, @RequestHeader Map<String, String> header
    ) {

        CustomResponseMainBody mainBody = service.getClinicListByUsername(username);

        CustomResponse response = rf.responseFinalize(mainBody, header);

        return new ResponseEntity<>(response, mainBody.getHttpStatusCode());

    }


}
