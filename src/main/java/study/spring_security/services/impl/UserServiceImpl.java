package study.spring_security.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import study.spring_security.DTOs.UserReqDTO;
import study.spring_security.DTOs.UserResDTO;
import study.spring_security.models.Role;
import study.spring_security.models.User;
import study.spring_security.repo.UserRepository;
import study.spring_security.services.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserResDTO> getAllUsers() {
        return ((List<User>) userRepository.findAll()).stream()
                .map(user -> modelMapper.map(user, UserResDTO.class))
                .toList();
    }

    @Override
    public UserResDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(user, UserResDTO.class);
    }

    @Override
    public UserResDTO updateUser(Long id, UserReqDTO userReqDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setUsername(userReqDTO.getUsername());
        existingUser.setPassword(passwordEncoder.encode(userReqDTO.getPassword()));
        existingUser.setEmail(userReqDTO.getEmail());

        User updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserResDTO.class);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }

        userRepository.deleteById(id);
    }
}