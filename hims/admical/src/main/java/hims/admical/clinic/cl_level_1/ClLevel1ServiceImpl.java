package hims.admical.clinic.cl_level_1;

import hims.admical.clinic.cl_level_2.ClLevel2;
import hims.admical.clinic.cl_level_2.ClLevel2DAOInt;
import hims.common.ClientMessages;
import hims.common.CustomException;
import hims.common.CustomResponseMainBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.stream.Stream;


@Service
public class ClLevel1ServiceImpl implements ClLevel1ServiceInt {

    private ClLevel1DAOInt dao;
    private ClLevel2DAOInt l2dao;

    private HttpStatus httpStatusCode;
    private String msgCode;
    private String msg;

    @Autowired
    public ClLevel1ServiceImpl(ClLevel1DAOInt dao, ClLevel2DAOInt l2dao) {
        this.dao = dao;
        this.l2dao = l2dao;
    }

    @Override
    public CustomResponseMainBody add(ClLevel1 clLevel1) {

        ClLevel1 newClLevel1 = null;

        try {

            newClLevel1 = dao.add(clLevel1);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_level_1_option_successfully_added";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<ClLevel1> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newClLevel1);

        return mainBody;
    }

    @Override
    @Transactional
    public CustomResponseMainBody addClLevel2ThroughCascading(ClLevel1 clLevel1) {

        ClLevel1 newClLevel1 = null;

        try {

            newClLevel1 = dao.add(clLevel1);

            Iterator<ClLevel2> iterator = clLevel1.getClLevel2List().iterator();
            while (iterator.hasNext()) {

                ClLevel2 clLevel2 = iterator.next();
                clLevel2.setClLevel1(newClLevel1);

                l2dao.add(clLevel2);

            }

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_level_1_option_level_2_options_successfully_added";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<ClLevel1> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newClLevel1);

        return mainBody;
    }

    @Override
    public CustomResponseMainBody getList(Pageable pageable) {

        Page<ClLevel1> page = dao.getList(pageable);
        long len = page.get().count();

        this.httpStatusCode = HttpStatus.OK;
        this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
        this.msg = "cl_level_1_options_found";

        if (len == 0) {

            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
            this.msg = "no_cl_level_1_option_found";
        }


        CustomResponseMainBody<Stream<ClLevel1>> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, page.get());

        return mainBody;

    }

    @Override
    public CustomResponseMainBody getByL1id(int l1id) {

        ClLevel1 existingClLevel1 = null;

        try {

            existingClLevel1 = dao.getByL1id(l1id);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
            this.msg = "cl_level_1_option_found";

        } catch (CustomException ex) {

            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
            this.msg = "no_cl_level_1_option_found";
        }

        CustomResponseMainBody<ClLevel1> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, existingClLevel1);

        return mainBody;

    }

    @Override
    public CustomResponseMainBody edit(ClLevel1 clLevel1) {

        ClLevel1 updatedClLevel1 = null;

        try {

            updatedClLevel1 = dao.edit(clLevel1);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_level_1_option_successfully_updated";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<ClLevel1> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, updatedClLevel1);

        return mainBody;
    }

    @Override
    public CustomResponseMainBody deleteByL1id(int l1id) {

        try {

            dao.deleteByL1id(l1id);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_DELETED.getMsgCode();
            this.msg = "cl_level_1_option_successfully_deleted";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, null);

        return mainBody;
    }
}
