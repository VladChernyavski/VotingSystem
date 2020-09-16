package by.chernyavski;

import by.chernyavski.model.Role;
import by.chernyavski.model.User;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import java.util.HashSet;

public class UserTestData {

    public static final User USER = new User(1000, "User", "user@gmail.com", "password", new HashSet<>(){{add(Role.USER);}});
    public static final User ADMIN = new User(1001, "Admin", "admin@gmail.com", "admin", new HashSet<>(){{add(Role.ADMIN);}});

    public static RequestPostProcessor userHttpBasic(User user) {
        return SecurityMockMvcRequestPostProcessors.httpBasic(user.getEmail(), user.getPassword());
    }

}
