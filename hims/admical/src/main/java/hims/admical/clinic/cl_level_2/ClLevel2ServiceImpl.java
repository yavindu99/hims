package hims.admical.clinic.cl_level_2;

import hims.admical.clinic.cl_level_1.ClLevel1DAOInt;
import hims.common.ClientMessages;
import hims.common.CustomException;
import hims.common.CustomResponseMainBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class ClLevel2ServiceImpl implements ClLevel2ServiceInt {

    private ClLevel1DAOInt l1Dao;
    private ClLevel2DAOInt dao;

    private HttpStatus httpStatusCode;
    private String msgCode;
    private String msg;

    @Autowired
    public ClLevel2ServiceImpl(ClLevel2DAOInt dao, ClLevel1DAOInt l1Dao) {
        this.dao = dao;
        this.l1Dao = l1Dao;
    }

    @Override
    public CustomResponseMainBody addList(List<ClLevel2> clLevel2List) {

        List<ClLevel2> newClLevel2List = null;

        try {

            newClLevel2List = dao.addList(clLevel2List);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_level_2_option_list_successfully_added";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<List<ClLevel2>> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newClLevel2List);

        return mainBody;

    }

    @Override
    public CustomResponseMainBody add(ClLevel2 clLevel2) {

        ClLevel2 newClLevel2 = null;

        try {

            if(Objects.nonNull(clLevel2.getClLevel1())){

                l1Dao.getByL1id(clLevel2.getClLevel1().getL1id());

            }

            newClLevel2 = dao.add(clLevel2);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_level_2_option_successfully_added";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<ClLevel2> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newClLevel2);

        return mainBody;

    }

    @Override
    public CustomResponseMainBody getByL2id(int l2id) {

        ClLevel2 existingClLevel2 = null;

        try {

            existingClLevel2 = dao.getByL2id(l2id);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
            this.msg = "cl_level_2_option_found";

        } catch (CustomException ex) {

            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
            this.msg = "no_cl_level_2_option_found";
        }

        CustomResponseMainBody<ClLevel2> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, existingClLevel2);

        return mainBody;

    }

    @Override
    public CustomResponseMainBody getList(Pageable pageable) {

        Page<ClLevel2> page = dao.getList(pageable);

        long len = page.get().count();

        this.httpStatusCode = HttpStatus.OK;
        this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
        this.msg = "cl_level_2_options_found";

        if (len == 0) {

            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
            this.msg = "no_cl_level_2_option_found";
        }

        CustomResponseMainBody<Stream<ClLevel2>> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, page.get());

        return mainBody;

    }

    @Override
    public CustomResponseMainBody edit(ClLevel2 clLevel2) {

        ClLevel2 updatedClLevel2 = null;

        try {

            updatedClLevel2 = dao.edit(clLevel2);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_level_2_option_successfully_updated";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<ClLevel2> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, updatedClLevel2);

        return mainBody;

    }

    @Override
    public CustomResponseMainBody deleteByL2id(int l2id) {

        try {

            dao.deleteByL2id(l2id);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_DELETED.getMsgCode();
            this.msg = "cl_level_2_option_successfully_deleted";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, null);

        return mainBody;

    }
}
