package hims.admical.clinic.cl_level_4;

import hims.admical.clinic.cl_level_3.ClLevel3DAOInt;
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
public class ClLevel4ServiceImpl implements ClLevel4ServiceInt {

    private EntityManagerFactory emf;
    private ClLevel3DAOInt l3Dao;
    private ClLevel4DAOInt dao;

    private HttpStatus httpStatusCode;
    private String msgCode;
    private String msg;

    @Autowired
    public ClLevel4ServiceImpl(ClLevel4DAOInt dao, ClLevel3DAOInt l3Dao, EntityManagerFactory emf) {
        this.dao = dao;
        this.l3Dao = l3Dao;
        this.emf = emf;
    }

    @Override
    public CustomResponseMainBody addList(List<ClLevel4> clLevel4List) {

        List<ClLevel4> newClLevel4List = null;

        try {

            newClLevel4List = dao.addList(clLevel4List);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_level_4_option_list_successfully_added";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<List<ClLevel4>> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newClLevel4List);

        return mainBody;

    }

    @Override
    public CustomResponseMainBody add(ClLevel4 clLevel4) {

        ClLevel4 newClLevel4 = null;

        try {

            if(Objects.nonNull(clLevel4.getClLevel3())){

                l3Dao.getByL3id(clLevel4.getClLevel3().getL3id());

            }

            newClLevel4 = dao.add(clLevel4);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_level_4_option_successfully_added";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<ClLevel4> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, newClLevel4);

        return mainBody;

    }

    @Override
    public CustomResponseMainBody getByL4id(int l4id) {

        ClLevel4 existingClLevel4 = null;

        try {

            existingClLevel4 = dao.getByL4id(l4id);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
            this.msg = "cl_level_4_option_found";

        } catch (CustomException ex) {

            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
            this.msg = "no_cl_level_4_option_found";
        }

        CustomResponseMainBody<ClLevel4> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, existingClLevel4);

        return mainBody;

    }

    @Override
    public CustomResponseMainBody getList(Pageable pageable) {

        Page<ClLevel4> page = dao.getList(pageable);
        long len = page.get().count();

        this.httpStatusCode = HttpStatus.OK;
        this.msgCode = ClientMessages.RECORDS_FOUND.getMsgCode();
        this.msg = "cl_level_4_options_found";

        if (len == 0) {

            this.msgCode = ClientMessages.NO_RECORDS_FOUND.getMsgCode();
            this.msg = "no_cl_level_4_option_found";
        }

        CustomResponseMainBody<Stream<ClLevel4>> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, page.get());

        return mainBody;

    }

    @Override
    public CustomResponseMainBody edit(ClLevel4 clLevel4) {

        ClLevel4 updatedClLevel4 = null;

        try {

            updatedClLevel4 = dao.edit(clLevel4);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_ADDED.getMsgCode();
            this.msg = "cl_level_4_option_successfully_updated";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody<ClLevel4> mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, updatedClLevel4);

        return mainBody;

    }

    @Override
    public CustomResponseMainBody deleteByL4id(int l4id) {

        try {

            dao.deleteByL4id(l4id);

            this.httpStatusCode = HttpStatus.OK;
            this.msgCode = ClientMessages.SUCCESSFULLY_DELETED.getMsgCode();
            this.msg = "cl_level_4_option_successfully_deleted";

        } catch (CustomException ex) {

            this.httpStatusCode = ex.getHttpStatus();
            this.msgCode = ex.getCode();
            this.msg = ex.getMsg();

        }

        CustomResponseMainBody mainBody = new CustomResponseMainBody<>(this.httpStatusCode, this.msgCode, this.msg, null);

        return mainBody;

    }
}
