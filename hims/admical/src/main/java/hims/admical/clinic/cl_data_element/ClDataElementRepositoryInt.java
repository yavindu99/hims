package hims.admical.clinic.cl_data_element;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ClDataElementRepositoryInt extends JpaRepository<ClDataElement,Integer> {

    ClDataElement findClDataElementByUid(String uid);
    @Modifying
    @Query(value = "INSERT INTO  cl_child_data_element (dataElementId,childDataElementId) VALUES (:parentDataElementId,:childDataElementId)",nativeQuery = true)
    void assignChildElementList(@Param("parentDataElementId") int parentDataElementId,@Param("childDataElementId") int childDataElementId);

}
