package hims.admical.administrative.department.departmentType;

import hims.common.ClientMessages;
import hims.common.CustomException;
import hims.common.CustomResponseMainBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentTypeServiceImpl implements DepartmentTypeServiceInt{

    private DepartmentTypeDAOInt dao;
    private HttpStatus httpStatusCode;
    private String msgCode;
    private String msg;

    @Autowired
    public DepartmentTypeServiceImpl(DepartmentTypeDAOInt dao) {
        this.dao = dao;
    }

    public CustomResponseMainBody add(DepartmentType departmentType){

        DepartmentType newDepartmentType = null;

        try{

            newDepartmentType = dao.add(departmentType);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "department_type_successfully_added";

        }catch (CustomException ex){

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody mainBody = new CustomResponseMainBody<>(
                this.httpStatusCode,
                this.msgCode,
                this.msg,
                newDepartmentType);


        return mainBody;

    }

    @Override
    public CustomResponseMainBody getByDepartmentTypeId(int id) {

        DepartmentType departmentType = dao.getByDepartmentTypeId(id);

        this.httpStatusCode = HttpStatus.OK;
        this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
        this.msg = "department_type_found";

        if(departmentType == null){

            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
            this.msg = "no_department_type_found_by_given_id";
        }

        CustomResponseMainBody mainBody = new CustomResponseMainBody<>(
                this.httpStatusCode,
                this.msgCode,
                this.msg,
                departmentType);


        return mainBody;
    }

    @Override
    public CustomResponseMainBody getList() {

        List<DepartmentType> departmentTypeList = dao.getList();
        int len = departmentTypeList.size();

        this.httpStatusCode = HttpStatus.OK;
        this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
        this.msg = "department_types_found";

        if(len == 0){

            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
            this.msg = "no_department_types_found";
        }


        CustomResponseMainBody mainBody = new CustomResponseMainBody<>(
                this.httpStatusCode,
                this.msgCode,
                this.msg,
                departmentTypeList);


        return mainBody;
    }

    @Override
    public CustomResponseMainBody deleteByDepartmentTypeId(int id) {

        try{

            dao.deleteByDepartmentTypeId(id);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_DELETED.getMsgCode();
            this.msg = "department_type_successfully_deleted";

        }catch (CustomException ex){

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody mainBody = new CustomResponseMainBody<DepartmentType>(
                this.httpStatusCode,
                this.msgCode,
                this.msg,
                null);


        return mainBody;

    }

    @Override
    public CustomResponseMainBody edit(DepartmentType departmentType) {

        DepartmentType newDepartmentType = null;

        try{

            newDepartmentType = dao.edit(departmentType);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_UPDATED.getMsgCode();
            this.msg = "department_type_successfully_updated";

        }catch (CustomException ex){

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody mainBody = new CustomResponseMainBody<>(
                this.httpStatusCode,
                this.msgCode,
                this.msg,
                newDepartmentType);


        return mainBody;

    }
}
