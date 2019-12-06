package hims.admical.clinic.cl_level_4;

import hims.common.CustomResponseMainBody;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClLevel4ServiceInt {

    CustomResponseMainBody addList(List<ClLevel4> clLevel4List);
    CustomResponseMainBody add(ClLevel4 clLevel4);
    CustomResponseMainBody getList(Pageable pageable);
    CustomResponseMainBody getByL4id(int l4id);
    CustomResponseMainBody edit(ClLevel4 clLevel4);
    CustomResponseMainBody deleteByL4id(int l4id);
}
