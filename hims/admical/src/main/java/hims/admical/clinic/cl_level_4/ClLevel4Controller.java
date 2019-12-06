package hims.admical.clinic.cl_level_4;

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
@RequestMapping("/clLevel4")
public class ClLevel4Controller {

    private ClLevel4ServiceInt service;
    private ResponseFinalize rf;

    @Autowired
    public ClLevel4Controller(ClLevel4ServiceInt service, ResponseFinalize rf) {
        this.service = service;
        this.rf = rf;
    }

    @PostMapping("/add")
    public ResponseEntity<CustomResponse> add(
            @Valid @RequestBody ClLevel4 clLevel4, @RequestHeader Map<String, String> header
    ) {

        CustomResponseMainBody mainBody = service.add(clLevel4);

        CustomResponse response = rf.responseFinalize(mainBody, header);

        return new ResponseEntity<>(response, mainBody.getHttpStatusCode());

    }

    @PostMapping("/addList")
    public ResponseEntity<CustomResponse> addList(
            @Valid @RequestBody List<ClLevel4> clLevel4List, @RequestHeader Map<String, String> header
    ) {

        CustomResponseMainBody mainBody = service.addList(clLevel4List);

        CustomResponse response = rf.responseFinalize(mainBody, header);

        return new ResponseEntity<>(response, mainBody.getHttpStatusCode());

    }

    @PutMapping("/edit")
    public ResponseEntity<CustomResponse> edit(
            @Valid @RequestBody ClLevel4 clLevel4, @RequestHeader Map<String, String> header
    ) {

        CustomResponseMainBody mainBody = service.edit(clLevel4);

        CustomResponse response = rf.responseFinalize(mainBody, header);

        return new ResponseEntity<>(response, mainBody.getHttpStatusCode());

    }

    @GetMapping("/getList")
    public ResponseEntity<CustomResponse> getList(Pageable pageable, @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.getList(pageable);

        CustomResponse response = rf.responseFinalize(mainBody, header);

        return new ResponseEntity<>(response, mainBody.getHttpStatusCode());

    }

    @GetMapping("/getByL4id/{l4id}")
    public ResponseEntity<CustomResponse> getByL1id(@PathVariable(name = "l4id") int l4id, @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.getByL4id(l4id);

        CustomResponse response = rf.responseFinalize(mainBody, header);

        return new ResponseEntity<>(response, mainBody.getHttpStatusCode());

    }

    @DeleteMapping("/deleteByL4id/{l4id}")
    public ResponseEntity<CustomResponse> deleteByL1id(@PathVariable(name = "l4id") int l4id, @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.deleteByL4id(l4id);

        CustomResponse response = rf.responseFinalize(mainBody, header);

        return new ResponseEntity<>(response, mainBody.getHttpStatusCode());

    }


}
