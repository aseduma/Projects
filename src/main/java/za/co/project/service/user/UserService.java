package za.co.project.service.user;

import za.co.project.model.user.User;
import za.co.project.web.view.user.UserForm;

/**
 * Created by Azael on 2017/07/13.
 */
public interface UserService {
    User findUserByEmail(String email);
    void saveUser(UserForm userForm);
    void deleteUser(User user);
}
