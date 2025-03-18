package mchiir.testdocker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create User
    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    // Get All Users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get User by Username
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Update User by ID
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @Valid @RequestBody User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(updatedUser.getUsername());
            userRepository.save(user);
            return ResponseEntity.ok(user);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Delete User by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}