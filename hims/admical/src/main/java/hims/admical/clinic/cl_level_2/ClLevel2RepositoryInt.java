package hims.admical.clinic.cl_level_2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClLevel2RepositoryInt extends JpaRepository<ClLevel2,Integer> {

    ClLevel2 findClLevel2ByDuid(String duid);
    ClLevel2 findClLevel2ByName(String name);
    Page<ClLevel2> findAll(Pageable pageable);

}
