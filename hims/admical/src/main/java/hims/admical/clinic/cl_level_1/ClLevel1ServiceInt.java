package hims.admical.clinic.cl_level_1;

import hims.common.CustomResponseMainBody;
import org.springframework.data.domain.Pageable;

public interface ClLevel1ServiceInt {

    CustomResponseMainBody add(ClLevel1 clLevel1);
    CustomResponseMainBody addClLevel2ThroughCascading(ClLevel1 clLevel1);
    CustomResponseMainBody getList(Pageable pageable);
    CustomResponseMainBody getByL1id(int l1id);
    CustomResponseMainBody edit(ClLevel1 clLevel1);
    CustomResponseMainBody deleteByL1id(int dataElementId);
}
