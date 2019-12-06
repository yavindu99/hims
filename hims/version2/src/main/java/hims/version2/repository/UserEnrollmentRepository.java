package hims.version2.repository;

import hims.version2.entitry.UserEnrollment;
import hims.version2.entitry.UserEnrollmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface UserEnrollmentRepository extends JpaRepository<UserEnrollment, UserEnrollmentId> {

	UserEnrollment findFirstByUser_UserId(String userId);
	List<UserEnrollment> findUserEnrollmentsByUser_UserId(String userId);

}
