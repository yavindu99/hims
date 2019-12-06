package hims.admical.clinic.cl_level_3;

import hims.common.CustomResponseMainBody;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClLevel3ServiceInt {

    CustomResponseMainBody addList(List<ClLevel3> clLevel3List);
    CustomResponseMainBody add(ClLevel3 clLevel3);
    CustomResponseMainBody getList(Pageable pageable);
    CustomResponseMainBody getByL3id(int l3id);
    CustomResponseMainBody edit(ClLevel3 clLevel3);
    CustomResponseMainBody deleteByL3id(int l3id);
}
