package hims.admical.clinic.cl_level_4;

import hims.common.CustomException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClLevel4DAOInt {

    List<ClLevel4> addList(List<ClLevel4> clLevel4List)throws CustomException;
    ClLevel4 add(ClLevel4 clLevel4)throws CustomException;
    Page<ClLevel4> getList(Pageable pageable);
    ClLevel4 getByL4id(int l4id)throws CustomException;
    ClLevel4 edit(ClLevel4 clLevel4)throws CustomException;
    void deleteByL4id(int l4id)throws CustomException;

}
