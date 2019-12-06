package hims.admical.clinic.cl_data_element;

import hims.common.CustomResponse;
import hims.common.CustomResponseMainBody;
import hims.common.ResponseFinalize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clDataElement")
public class ClDataElementController {

    private ClDataElementServiceInt service;
    private ResponseFinalize rf;

    @Autowired
    public ClDataElementController(ClDataElementServiceInt service, ResponseFinalize rf) {
        this.service = service;
        this.rf = rf;
    }

    @PostMapping("/add")
    public ResponseEntity<CustomResponse> add(@RequestBody ClDataElement clDataElement,
                                                               @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.add(clDataElement);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @PostMapping("/addList")
    public ResponseEntity<CustomResponse> addList(@RequestBody List<ClDataElement> clDataElementList,
                                              @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.addList(clDataElementList);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @PostMapping("/assignChildElementList")
    public ResponseEntity<CustomResponse> assignChildElementList(@RequestBody ClDataElement clDataElement,
                                              @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.assignChildElementList(clDataElement);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }


    @PostMapping("/assignCategories")
    public ResponseEntity<CustomResponse> assignCategories(@RequestBody ClDataElement clDataElement,
                                              @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.assignCategories(clDataElement);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @GetMapping("/getByDataElementId/{dataElementId}")
    public ResponseEntity<CustomResponse> getByDataElementId(@PathVariable(name = "dataElementId") int dataElementId,
                                              @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.getByDataElementId(dataElementId);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }


}
