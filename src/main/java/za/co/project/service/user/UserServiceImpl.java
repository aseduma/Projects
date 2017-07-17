package za.co.project.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import za.co.project.model.user.Role;
import za.co.project.model.user.User;
import za.co.project.model.user.UserRole;
import za.co.project.repository.user.RoleRepository;
import za.co.project.repository.user.UserRepository;
import za.co.project.repository.user.UserRoleRepository;

/**
 * Created by Azael on 2017/07/13.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;


    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setActive(true);
        userRepository.save(user);
        saveUserRole(user, "USER");
    }

    @Override
    public void deleteUser(User user) {
        userRoleRepository.findAllByUser(user).forEach(userRoleRepository::delete);
        userRepository.delete(user);
    }

    private void saveUserRole(User user, String roleName) {
        Role role = roleRepository.findByRole(roleName);
        if (role != null && !hasRole(user, role)) {
            UserRole userRole = new UserRole();
            userRole.setUser(user);
            userRole.setRole(role);
            userRoleRepository.save(userRole);
        }
    }

    private boolean hasRole(User user, Role role) {
        for (UserRole userRole : user.getUserRoles()) {
            if (userRole.getRole().getRole().equals(role.getRole())) {
                return true;
            }
        }
        return false;
    }
}
