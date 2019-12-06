package hims.admical.clinic.cl_level_3;

import hims.common.CustomException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClLevel3DAOInt {

    List<ClLevel3> addList(List<ClLevel3> clLevel3List)throws CustomException;
    ClLevel3 add(ClLevel3 clLevel3)throws CustomException;
    Page<ClLevel3> getList(Pageable pageable);
    ClLevel3 getByL3id(int l3id)throws CustomException;
    ClLevel3 edit(ClLevel3 clLevel3)throws CustomException;
    void deleteByL3id(int l3id)throws CustomException;

}
