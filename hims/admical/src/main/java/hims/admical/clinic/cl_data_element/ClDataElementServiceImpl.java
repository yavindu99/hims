package hims.admical.clinic.cl_data_element;

import hims.common.ClientMessages;
import hims.common.CustomException;
import hims.common.CustomResponseMainBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;


@Service
public class ClDataElementServiceImpl implements ClDataElementServiceInt {

    private ClDataElementDAOInt dao;

    private HttpStatus httpStatusCode;
    private String msgCode;
    private String msg;

    @Autowired
    public ClDataElementServiceImpl(ClDataElementDAOInt dao) {
        this.dao = dao;
    }

    @Override
    public CustomResponseMainBody add(ClDataElement clDataElement) {

        ClDataElement newClDataElement = null;

        try {

            newClDataElement = dao.add(clDataElement);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_data_element_successfully_added";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<ClDataElement> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newClDataElement);

        return mainBody;
    }

    @Override
    public CustomResponseMainBody addList(List<ClDataElement> clDataElementList) {

        List<ClDataElement> newClDataElementList = null;

        try {

            newClDataElementList = dao.addList(clDataElementList);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_data_element_successfully_added";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<List<ClDataElement>> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newClDataElementList);

        return mainBody;
    }

    @Override
    public CustomResponseMainBody assignChildElementList(ClDataElement clDataElement) {

        ClDataElement newClDataElement = null;

        try {

            newClDataElement = dao.assignChildElementList(clDataElement);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_child_data_element_successfully_assigned";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<ClDataElement> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newClDataElement);

        return mainBody;
    }

    @Override
    public CustomResponseMainBody assignCategories(ClDataElement clDataElement) {

        ClDataElement newClDataElement = null;

        try {

            newClDataElement = dao.assignCategories(clDataElement);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_data_element_to_cl_category_successfully_assigned";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<ClDataElement> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newClDataElement);

        return mainBody;
    }

    @Override
    public CustomResponseMainBody edit(ClDataElement clDataElement) {

        ClDataElement editedClDataElement = null;

        try {

            editedClDataElement = dao.edit(clDataElement);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_data_element_successfully_edited";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<ClDataElement> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, editedClDataElement);

        return mainBody;
    }

    @Override
    public CustomResponseMainBody deleteByDataElementId(int dataElementId) {
        try {

            dao.deleteByDataElementId(dataElementId);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_DELETED.getMsgCode();
            this.msg = "cl_data_element_successfully_deleted";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, null);

        return mainBody;
    }

    @Override
    public CustomResponseMainBody getList(Pageable pageable) {

        Page<ClDataElement> page = dao.getList(pageable);
        long len = page.get().count();

        this.httpStatusCode = HttpStatus.OK;
        this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
        this.msg = "cl_data_elements_found";

        if (len == 0) {

            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
            this.msg = "no_cl_data_element_found";
        }


        CustomResponseMainBody<Stream<ClDataElement>> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, page.get());

        return mainBody;

    }

    @Override
    public CustomResponseMainBody getByDataElementId(int dataElementId) {

        ClDataElement clDataElement = null;

        try {

            clDataElement = dao.getByDataElementId(dataElementId);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
            this.msg = "cl_data_element_found";

        } catch (CustomException ex) {

            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
            this.msg = "no_cl_data_element_found";
        }

        CustomResponseMainBody<ClDataElement> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, clDataElement);

        return mainBody;

    }

    @Override
    public CustomResponseMainBody getByUid(String uid) {

        ClDataElement clDataElement = null;

        try {

            clDataElement = dao.getByUid(uid);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
            this.msg = "cl_data_element_found";

        } catch (CustomException ex) {

            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
            this.msg = "no_cl_data_element_found";
        }

        CustomResponseMainBody<ClDataElement> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, clDataElement);

        return mainBody;
    }

}
