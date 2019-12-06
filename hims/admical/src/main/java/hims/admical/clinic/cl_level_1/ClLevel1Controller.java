package hims.admical.clinic.cl_level_1;

import com.fasterxml.jackson.databind.ObjectMapper;
import hims.admical.clinic.cl_level_2.ClLevel2;
import hims.common.CustomResponse;
import hims.common.CustomResponseMainBody;
import hims.common.ResponseFinalize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

@RestController
@RequestMapping("/clLevel1")
public class ClLevel1Controller {

    private ClLevel1ServiceInt service;
    private ResponseFinalize rf;

    @Autowired
    public ClLevel1Controller(ClLevel1ServiceInt service,ResponseFinalize rf) {
        this.service = service;
        this.rf = rf;
    }

    @PostMapping("/add")
    public ResponseEntity<CustomResponse> add(@Valid @RequestBody ClLevel1 clLevel1,
                                                               @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.add(clLevel1);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @PutMapping("/edit")
    public ResponseEntity<CustomResponse> edit(@Valid @RequestBody ClLevel1 clLevel1,
                                              @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.edit(clLevel1);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @PostMapping("/addClLevel2ThroughCascading")
    public ResponseEntity<CustomResponse> addClLevel2ThroughCascading(@Valid @RequestBody ClLevel1 clLevel1,
                                                                          @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.addClLevel2ThroughCascading(clLevel1);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @GetMapping("/getList")
    public ResponseEntity<CustomResponse> getList(Pageable pageable, @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.getList(pageable);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @GetMapping("/getByL1id/{l1id}")
    public ResponseEntity<CustomResponse> getByL1id(@PathVariable(name = "l1id") int l1id,@RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.getByL1id(l1id);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @DeleteMapping("/deleteByL1id/{l1id}")
    public ResponseEntity<CustomResponse> deleteByL1id(@PathVariable(name = "l1id") int l1id,@RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.deleteByL1id(l1id);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

}
