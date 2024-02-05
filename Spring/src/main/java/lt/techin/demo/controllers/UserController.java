package lt.techin.demo.controllers;

import lt.techin.demo.models.User;
import lt.techin.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return this.userService.getAllUsers();
    }


//    @GetMapping("/users/{id}")
//    public User getUser(@PathVariable long id) {
//        return this.userService.findUserById(id);
//    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        User savedUser = this.userService.saveUser(user);

        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri()).body(savedUser);
    }

//    @PostMapping("/users")
//    public ResponseEntity<User> insertUser(@RequestBody User user) {
//        User savedUser = this.userService.saveUser(user);
//
//        return ResponseEntity
//                .created(ServletUriComponentsBuilder.fromCurrentRequest()
//                        .path("/{id}").buildAndExpand(savedUser.getId())
//                        .toUri())
//                .body(savedUser);
//    }

//    @PutMapping("/users/{id}")
//    public User updateUser(@RequestBody User user, @PathVariable long id) {
//        if (this.userService.existsUserById(id)) {
//            User userFromDb = this.userService.findUserById(id);
//
//            userFromDb.setUsername(user.getUsername());
//            userFromDb.setPassword(user.getPassword());
//
//            return this.userService.saveUserFromDb;
//        }
//
//        return this.userService.saveUser(user);
//    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id) {
        this.userService.deleteUserById(id);
    }
}
