package za.co.project.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.project.model.user.User;
import za.co.project.model.user.UserRole;

import java.util.List;

/**
 * Created by Azael on 2017/07/13.
 */
@Repository("userRoleRepository")
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findAllByUser(User user);
}
