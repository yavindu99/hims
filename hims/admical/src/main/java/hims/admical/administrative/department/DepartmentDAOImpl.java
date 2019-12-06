package hims.admical.administrative.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DepartmentDAOImpl implements DepartmentDAOInt {

    private DepartmentRepositoryInt repo;

    @Autowired
    public DepartmentDAOImpl(DepartmentRepositoryInt repo) {
        this.repo = repo;
    }

    @Override
    public Department addNewDepartment(Department department) {

        return repo.save(department);

    }

    @Override
    public List<Department> getAllDepartments() {

        return repo.findAll();
    }

    @Override
    public Department updateDepartment(Department department) {

        return repo.save(department);
    }

    @Override
    public Department deleteDepartmentByDepartmentId(int departmentId) {

        Department department = repo.findById(departmentId).orElse(null);

        repo.delete(department);

        return department;

    }

    @Override
    public Department getDepartmentByDeprtmentName(String departmentName) {

        return repo.findDepartmentByDepartmentName(departmentName);

    }
}
