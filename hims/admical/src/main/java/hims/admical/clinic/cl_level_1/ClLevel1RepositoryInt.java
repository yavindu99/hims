package hims.admical.clinic.cl_level_1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClLevel1RepositoryInt extends JpaRepository<ClLevel1,Integer> {

    ClLevel1 findClLevel1ByDuid(String duid);
    ClLevel1 findClLevel1ByName(String name);

}
