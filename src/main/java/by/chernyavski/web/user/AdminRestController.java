package by.chernyavski.web.user;

import by.chernyavski.model.User;
import by.chernyavski.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestController {

    private final UserService userService;

    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        return userService.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user, @PathVariable int id){
        User updated = userService.get(id);
        updated.setName(user.getName());
        updated.setEmail(user.getEmail());
        updated.setRoles(user.getRoles());

        userService.update(updated);
    }

}
