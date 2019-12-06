package hims.admical.administrative.department;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admical/department")
public class DepartmentControllerImpl {

    private DepartmentDAOInt dao;

    public DepartmentControllerImpl(DepartmentDAOInt dao) {
        this.dao = dao;
    }

    @PostMapping("/addNewDepartment")
    public Department addNewDepartment(@RequestBody Department department){

        Department newDepartment = dao.addNewDepartment(department);

        return newDepartment;

    }


}
