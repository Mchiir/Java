package study.spring_security.cont;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import study.spring_security.DTO.AuthReq;
import study.spring_security.DTO.UserReqDTO;
import study.spring_security.DTO.UserResDTO;
import study.spring_security.models.Role;
import study.spring_security.models.User;
import study.spring_security.repo.UserRepository;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;


    // Create User
    @PostMapping("/registerUser")
    public ResponseEntity<?> register(@Valid @RequestBody UserReqDTO userReqDTO) {
        try {
            if (userRepository.existsByUsername(userReqDTO.getUsername())) {
                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body("Username already exists");
            }

            if (userRepository.existsByEmail(userReqDTO.getEmail())) {
                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body("Email already in use");
            }

            var role = new Role();
            role.setName("ROLE_USER");

            var newUser = new User(
                    userReqDTO.getUsername(),
                    passwordEncoder.encode(userReqDTO.getPassword()),
                    userReqDTO.getEmail(),
                    List.of(role)
            );

            User savedUser = userRepository.save(newUser);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(modelMapper.map(savedUser, UserResDTO.class));

        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Database error: " + ex.getMostSpecificCause().getMessage());
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Unexpected error occurred: " + ex.getMessage());
        }
    }

    @PostMapping("/loginUser")
    public ResponseEntity<UserResDTO> login(@Valid @RequestBody AuthReq authReq) {
        return ResponseEntity.ok(modelMapper.map(authReq, UserResDTO.class));
    }

    // Get All Users
    @GetMapping
    public ResponseEntity<Iterable<UserResDTO>> getAllUsers() {
        List<User> savedUsers = (List<User>) userRepository.findAll();

        List<UserResDTO> authResList = savedUsers.stream()
                .map(user -> modelMapper.map(user, UserResDTO.class))
                .toList();
        return ResponseEntity.ok(authResList);
    }

    // Get Single User by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResDTO> getUserById(@PathVariable Long id) {
        User savedUser = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));

        return ResponseEntity.ok(modelMapper.map(savedUser, UserResDTO.class));
    }

    // Update User
    @PutMapping("/{id}")
    public ResponseEntity<UserResDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserReqDTO userReqDTO) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

//        updatedUser.setId(id); // Ensure the ID is set
        User existingUser = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));

        existingUser.setUsername(userReqDTO.getUsername());
        existingUser.setPassword(userReqDTO.getPassword());
        existingUser.setEmail(userReqDTO.getEmail());

        User updatedUser = userRepository.save(existingUser);

        return ResponseEntity.ok(modelMapper.map(updatedUser, UserResDTO.class));
    }

    // Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        userRepository.deleteById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "User deleted successfully");
        return ResponseEntity.ok(response);
    }
}