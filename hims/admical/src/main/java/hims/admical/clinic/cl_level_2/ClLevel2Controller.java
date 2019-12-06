package hims.admical.clinic.cl_level_2;

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
@RequestMapping("/clLevel2")
public class ClLevel2Controller {

    private ClLevel2ServiceInt service;
    private ResponseFinalize rf;

    @Autowired
    public ClLevel2Controller(ClLevel2ServiceInt service, ResponseFinalize rf) {
        this.service = service;
        this.rf = rf;
    }

    @PostMapping("/add")
    public ResponseEntity<CustomResponse> add(
            @Valid @RequestBody ClLevel2 clLevel2, @RequestHeader Map<String, String> header
    ) {

        CustomResponseMainBody mainBody = service.add(clLevel2);

        CustomResponse response = rf.responseFinalize(mainBody, header);

        return new ResponseEntity<>(response, mainBody.getHttpStatusCode());

    }

    @PostMapping("/addList")
    public ResponseEntity<CustomResponse> addList(
            @Valid @RequestBody List<ClLevel2> clLevel2List, @RequestHeader Map<String, String> header
    ) {

        CustomResponseMainBody mainBody = service.addList(clLevel2List);

        CustomResponse response = rf.responseFinalize(mainBody, header);

        return new ResponseEntity<>(response, mainBody.getHttpStatusCode());

    }

    @PutMapping("/edit")
    public ResponseEntity<CustomResponse> edit(
            @Valid @RequestBody ClLevel2 clLevel2, @RequestHeader Map<String, String> header
    ) {

        CustomResponseMainBody mainBody = service.edit(clLevel2);

        CustomResponse response = rf.responseFinalize(mainBody, header);

        return new ResponseEntity<>(response, mainBody.getHttpStatusCode());

    }

    @GetMapping("/getList")
    public ResponseEntity<CustomResponse> getList(Pageable pageable, @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.getList(pageable);

        CustomResponse response = rf.responseFinalize(mainBody, header);

        return new ResponseEntity<>(response, mainBody.getHttpStatusCode());

    }

    @GetMapping("/getByL2id/{l2id}")
    public ResponseEntity<CustomResponse> getByL1id(@PathVariable(name = "l2id") int l2id, @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.getByL2id(l2id);

        CustomResponse response = rf.responseFinalize(mainBody, header);

        return new ResponseEntity<>(response, mainBody.getHttpStatusCode());

    }

    @DeleteMapping("/deleteByL2id/{l2id}")
    public ResponseEntity<CustomResponse> deleteByL1id(@PathVariable(name = "l2id") int l2id, @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.deleteByL2id(l2id);

        CustomResponse response = rf.responseFinalize(mainBody, header);

        return new ResponseEntity<>(response, mainBody.getHttpStatusCode());

    }


}
