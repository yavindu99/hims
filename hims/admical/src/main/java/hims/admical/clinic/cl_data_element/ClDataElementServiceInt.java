package hims.admical.clinic.cl_data_element;

import hims.common.CustomResponseMainBody;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClDataElementServiceInt {

    CustomResponseMainBody add(ClDataElement clDataElement);
    CustomResponseMainBody addList(List<ClDataElement> clDataElementList);
    CustomResponseMainBody assignChildElementList(ClDataElement clDataElement);
    CustomResponseMainBody assignCategories(ClDataElement clDataElement);
    CustomResponseMainBody edit(ClDataElement clDataElement);
    CustomResponseMainBody deleteByDataElementId(int l1id);
    CustomResponseMainBody getList(Pageable pageable);
    CustomResponseMainBody getByDataElementId(int dataElementId);
    CustomResponseMainBody getByUid(String uid);
}
