package hims.admical.clinic.cl_data_element;

import hims.common.CustomException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClDataElementDAOInt {

    ClDataElement add(ClDataElement clDataElement)throws CustomException;
    List<ClDataElement> addList(List<ClDataElement> clDataElementList) throws CustomException;
    ClDataElement assignChildElementList(ClDataElement clDataElement) throws CustomException;
    ClDataElement assignCategories(ClDataElement clDataElement)throws CustomException;
    ClDataElement edit(ClDataElement clDataElement)throws CustomException;
    void deleteByDataElementId(int dataElementId)throws CustomException;
    Page<ClDataElement> getList(Pageable pageable);
    ClDataElement getByDataElementId(int dataElementId)throws CustomException;
    ClDataElement getByUid(String uid)throws CustomException;

}
