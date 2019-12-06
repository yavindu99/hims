package hims.version2.dao;

import hims.version2.entitry.Department;
import hims.version2.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("Version2DepartmentDAOImpl")
@Transactional
public class DepartmentDAOImpl implements DepartmentDAOInt {

    private DepartmentRepository repo;

    @Autowired
    public DepartmentDAOImpl(DepartmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Department getByDepartmentCode(String departmentCode) {

        return repo.findById(departmentCode).orElse(null);
    }

    @Override
    public Department getClinicByDepartmentCode(String departmentCode) {

        return repo.findDepartmentByDepartmentCodeAndDepartmentType(departmentCode,"CLINIC");
    }
}
