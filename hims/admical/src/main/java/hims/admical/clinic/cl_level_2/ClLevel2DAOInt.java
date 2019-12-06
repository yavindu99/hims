package hims.admical.clinic.cl_level_2;

import hims.common.CustomException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClLevel2DAOInt {

    List<ClLevel2> addList(List<ClLevel2> clLevel2List)throws CustomException;
    ClLevel2 add(ClLevel2 clLevel2)throws CustomException;
    Page<ClLevel2> getList(Pageable pageable);
    ClLevel2 getByL2id(int l2id)throws CustomException;
    ClLevel2 edit(ClLevel2 clLevel2)throws CustomException;
    void deleteByL2id(int l2id)throws CustomException;

}
