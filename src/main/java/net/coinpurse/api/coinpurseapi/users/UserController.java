package net.coinpurse.api.coinpurseapi.users;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable ObjectId id) {
        try {
            return new ResponseEntity<Optional<User>>(userService.getUser(id), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public List<User> createUser(@RequestBody User newUser) {
        userService.createUser(newUser);
        return userService.getUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable ObjectId id) {
        userService.deleteUser(id);
    }

    @PostMapping("/sessions")
    public AuthUser startSession(@RequestBody Session newSession) {
        return userService.getCredentials(newSession);
    }
}
