package hims.admical.administrative.department.departmentType;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentTypeRepositoryInt extends JpaRepository<DepartmentType,Integer> {


    DepartmentType findByDepartmentTypeName(String departmentTypeName);


}

