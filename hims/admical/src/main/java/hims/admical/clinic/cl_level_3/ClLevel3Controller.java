package hims.admical.clinic.cl_level_3;

import hims.common.CustomResponse;
import hims.common.CustomResponseMainBody;
import hims.common.ResponseFinalize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clLevel3")
public class ClLevel3Controller {

    private ClLevel3ServiceInt service;
    private ResponseFinalize rf;

    @Autowired
    public ClLevel3Controller(ClLevel3ServiceInt service, ResponseFinalize rf) {
        this.service = service;
        this.rf = rf;
    }

    @PostMapping("/add")
    public ResponseEntity<CustomResponse> add(
            @Valid @RequestBody ClLevel3 clLevel3, @RequestHeader Map<String, String> header
    ) {

        CustomResponseMainBody mainBody = service.add(clLevel3);

        CustomResponse response = rf.responseFinalize(mainBody, header);

        return new ResponseEntity<>(response, mainBody.getHttpStatusCode());

    }

    @PostMapping("/addList")
    public ResponseEntity<CustomResponse> addList(
            @Valid @RequestBody List<ClLevel3> clLevel3List, @RequestHeader Map<String, String> header
    ) {

        CustomResponseMainBody mainBody = service.addList(clLevel3List);

        CustomResponse response = rf.responseFinalize(mainBody, header);

        return new ResponseEntity<>(response, mainBody.getHttpStatusCode());

    }

    @PutMapping("/edit")
    public ResponseEntity<CustomResponse> edit(
            @Valid @RequestBody ClLevel3 clLevel3, @RequestHeader Map<String, String> header
    ) {

        CustomResponseMainBody mainBody = service.edit(clLevel3);

        CustomResponse response = rf.responseFinalize(mainBody, header);

        return new ResponseEntity<>(response, mainBody.getHttpStatusCode());

    }

    @GetMapping("/getList")
    public ResponseEntity<CustomResponse> getList(Pageable pageable, @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.getList(pageable);

        CustomResponse response = rf.responseFinalize(mainBody, header);

        return new ResponseEntity<>(response, mainBody.getHttpStatusCode());

    }

    @GetMapping("/getByL3id/{l3id}")
    public ResponseEntity<CustomResponse> getByL1id(@PathVariable(name = "l3id") int l3id, @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.getByL3id(l3id);

        CustomResponse response = rf.responseFinalize(mainBody, header);

        return new ResponseEntity<>(response, mainBody.getHttpStatusCode());

    }

    @DeleteMapping("/deleteByL3id/{l3id}")
    public ResponseEntity<CustomResponse> deleteByL1id(@PathVariable(name = "l3id") int l3id, @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.deleteByL3id(l3id);

        CustomResponse response = rf.responseFinalize(mainBody, header);

        return new ResponseEntity<>(response, mainBody.getHttpStatusCode());

    }


}
