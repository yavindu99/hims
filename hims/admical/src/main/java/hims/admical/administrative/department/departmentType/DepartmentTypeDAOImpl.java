package hims.admical.administrative.department.departmentType;


import hims.common.ClientMessages;
import hims.common.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DepartmentTypeDAOImpl implements DepartmentTypeDAOInt {

    private DepartmentTypeRepositoryInt repo;

    @Autowired
    public DepartmentTypeDAOImpl(DepartmentTypeRepositoryInt repo) {
        this.repo = repo;
    }

    @Override
    public DepartmentType add(DepartmentType departmentType) throws CustomException {

        DepartmentType existingDepartmentType = repo.findByDepartmentTypeName(departmentType.getDepartmentTypeName());

        if(existingDepartmentType != null){
            throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(),"duplicate_entry_department_type_name_cannot_be_duplicated");
        }

        return repo.save(departmentType);
    }

    @Override
    public List<DepartmentType> getList() {

        return repo.findAll();

    }

    @Override
    public DepartmentType getByDepartmentTypeId(int id) {

        return repo.findById(id).orElse(null);
    }

    @Override
    public DepartmentType edit(DepartmentType departmentType)throws CustomException {

        DepartmentType existingDepartmentType = this.getByDepartmentTypeId(departmentType.getDepartmentTypeId());

        if(existingDepartmentType == null){
            throw new CustomException(HttpStatus.BAD_REQUEST, ClientMessages.FAILED_UPDATE.getMsgCode(),"no_department_type_found_by_the_department_type_id");
        }

        existingDepartmentType = repo.findByDepartmentTypeName(departmentType.getDepartmentTypeName());

        if(existingDepartmentType != null){
            throw new CustomException(HttpStatus.CONFLICT, ClientMessages.FAILED_ADD.getMsgCode(),"duplicate_entry_department_type_name_cannot_be_duplicated");
        }

        return repo.save(departmentType);
    }

    @Override
    public void deleteByDepartmentTypeId(int id) throws CustomException {

        DepartmentType departmentType = this.getByDepartmentTypeId(id);

        if(departmentType == null){
            throw new CustomException(HttpStatus.BAD_REQUEST, ClientMessages.FAILED_DELETE.getMsgCode(),"no_department_type_found_by_the_department_type_id");
        }

        repo.delete(departmentType);

    }
}
