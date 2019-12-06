package hims.admical.clinic.cl_level_3;

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

import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class ClLevel3ServiceImpl implements ClLevel3ServiceInt {

    private EntityManagerFactory emf;
    private ClLevel2DAOInt l2Dao;
    private ClLevel3DAOInt dao;

    private HttpStatus httpStatusCode;
    private String msgCode;
    private String msg;

    @Autowired
    public ClLevel3ServiceImpl(ClLevel3DAOInt dao, ClLevel2DAOInt l2Dao, EntityManagerFactory emf) {
        this.dao = dao;
        this.l2Dao = l2Dao;
        this.emf = emf;
    }

    @Override
    public CustomResponseMainBody addList(List<ClLevel3> clLevel3List) {

        List<ClLevel3> newClLevel3List = null;

        try {

            newClLevel3List = dao.addList(clLevel3List);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_level_3_option_list_successfully_added";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<List<ClLevel3>> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newClLevel3List);

        return mainBody;

    }

    @Override
    public CustomResponseMainBody add(ClLevel3 clLevel3) {

        ClLevel3 newClLevel3 = null;

        try {

            if(Objects.nonNull(clLevel3.getClLevel2())){

                l2Dao.getByL2id(clLevel3.getClLevel2().getL2id());

            }

            newClLevel3 = dao.add(clLevel3);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_level_3_option_successfully_added";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<ClLevel3> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newClLevel3);

        return mainBody;

    }

    @Override
    public CustomResponseMainBody getByL3id(int l3id) {

        ClLevel3 existingClLevel3 = null;

        try {

            existingClLevel3 = dao.getByL3id(l3id);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
            this.msg = "cl_level_3_option_found";

        } catch (CustomException ex) {

            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
            this.msg = "no_cl_level_3_option_found";
        }

        CustomResponseMainBody<ClLevel3> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, existingClLevel3);

        return mainBody;

    }

    @Override
    public CustomResponseMainBody getList(Pageable pageable) {

        Page<ClLevel3> page = dao.getList(pageable);
        long len = page.get().count();

        this.httpStatusCode = HttpStatus.OK;
        this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
        this.msg = "cl_level_3_options_found";

        if (len == 0) {

            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
            this.msg = "no_cl_level_3_option_found";
        }

        CustomResponseMainBody<Stream<ClLevel3>> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, page.get());

        return mainBody;

    }

    @Override
    public CustomResponseMainBody edit(ClLevel3 clLevel3) {

        ClLevel3 updatedClLevel3 = null;

        try {

            updatedClLevel3 = dao.edit(clLevel3);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_level_3_option_successfully_updated";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<ClLevel3> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, updatedClLevel3);

        return mainBody;

    }

    @Override
    public CustomResponseMainBody deleteByL3id(int l3id) {

        try {

            dao.deleteByL3id(l3id);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_DELETED.getMsgCode();
            this.msg = "cl_level_3_option_successfully_deleted";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, null);

        return mainBody;

    }
}
