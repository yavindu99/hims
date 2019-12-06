package hims.admical.clinic.cl_level_3;

import hims.admical.clinic.cl_level_2.ClLevel2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClLevel3RepositoryInt extends JpaRepository<ClLevel3,Integer> {

    ClLevel3 findClLevel3ByDuid(String duid);
    ClLevel3 findClLevel3ByName(String name);

}
