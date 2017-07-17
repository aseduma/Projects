package za.co.project.service.user;

import za.co.project.model.user.User;

/**
 * Created by Azael on 2017/07/13.
 */
public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user);
    void deleteUser(User user);
}
