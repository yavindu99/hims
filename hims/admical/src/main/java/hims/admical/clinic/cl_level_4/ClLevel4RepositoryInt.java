package hims.admical.clinic.cl_level_4;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClLevel4RepositoryInt extends JpaRepository<ClLevel4,Integer> {

    ClLevel4 findClLevel4ByDuid(String duid);
    ClLevel4 findClLevel4ByName(String name);

}
