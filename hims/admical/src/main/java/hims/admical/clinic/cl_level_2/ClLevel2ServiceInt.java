package hims.admical.clinic.cl_level_2;

import hims.common.CustomResponseMainBody;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClLevel2ServiceInt {

    CustomResponseMainBody addList(List<ClLevel2> clLevel2List);
    CustomResponseMainBody add(ClLevel2 clLevel2);
    CustomResponseMainBody getList(Pageable pageable);
    CustomResponseMainBody getByL2id(int l2id);
    CustomResponseMainBody edit(ClLevel2 clLevel2);
    CustomResponseMainBody deleteByL2id(int l2id);
}
