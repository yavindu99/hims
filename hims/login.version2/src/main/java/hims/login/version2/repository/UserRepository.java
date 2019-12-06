package hims.login.version2.repository;

import hims.login.version2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, String> {

	User findUserByUserId(String userId);

}
