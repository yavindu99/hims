package hims.admical.clinic.cl_level_1;

import hims.common.CustomException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClLevel1DAOInt {

    ClLevel1 add(ClLevel1 clLevel1)throws CustomException;
    Page<ClLevel1> getList(Pageable pageable);
    ClLevel1 getByL1id(int l1id)throws CustomException;
    ClLevel1 edit(ClLevel1 clLevel1)throws CustomException;
    void deleteByL1id(int l1id)throws CustomException;

}
