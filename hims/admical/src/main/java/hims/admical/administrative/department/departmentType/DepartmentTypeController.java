package hims.admical.administrative.department.departmentType;

import hims.common.CustomResponse;
import hims.common.CustomResponseMainBody;
import hims.common.ResponseFinalize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


@RestController
@RequestMapping("/departmentType")
public class DepartmentTypeController {

    private DepartmentTypeServiceInt service;
    private ResponseFinalize rf;

    @Autowired
    public DepartmentTypeController(DepartmentTypeServiceInt service,ResponseFinalize rf) {
        this.service = service;
        this.rf = rf;
    }

    @PostMapping("/add")
    public ResponseEntity<CustomResponse> add(@Valid @RequestBody DepartmentType departmentType,
                                                               @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.add(departmentType);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @GetMapping("/getList")
    public ResponseEntity<CustomResponse> getList(@RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.getList();

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @PutMapping("/edit")
    public ResponseEntity<CustomResponse> edit(@RequestBody DepartmentType departmentType,
                                                               @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.edit(departmentType);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @DeleteMapping("/deleteByDepartmentTypeId/{id}")
    public ResponseEntity<CustomResponse> deleteByDepartmentTypeId(@PathVariable int id,
                                                               @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.deleteByDepartmentTypeId(id);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

    @GetMapping("/getByDepartmentTypeId/{id}")
    public ResponseEntity<CustomResponse> getByDepartmentTypeId(@PathVariable int id,
                                                                                 @RequestHeader Map<String, String> header) {

        CustomResponseMainBody mainBody = service.getByDepartmentTypeId(id);

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }


}
