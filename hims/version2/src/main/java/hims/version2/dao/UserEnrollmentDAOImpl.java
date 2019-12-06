package hims.version2.dao;

import hims.version2.entitry.UserEnrollment;
import hims.version2.repository.UserEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserEnrollmentDAOImpl implements UserEnrollmentDAOInt {

    private UserEnrollmentRepository repo;

    @Autowired
    public UserEnrollmentDAOImpl(UserEnrollmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<UserEnrollment> getListByUsername(String username) {

        return repo.findUserEnrollmentsByUser_UserId(username);

    }
}
