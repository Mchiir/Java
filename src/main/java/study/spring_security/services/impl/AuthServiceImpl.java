package study.spring_security.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import study.spring_security.DTOs.AuthReq;
import study.spring_security.DTOs.UserReqDTO;
import study.spring_security.DTOs.UserResDTO;
import study.spring_security.context.JwtTokenProvider;
import study.spring_security.models.Role;
import study.spring_security.models.User;
import study.spring_security.repo.UserRepository;
import study.spring_security.services.AuthService;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public AuthServiceImpl(ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public String login(AuthReq authReq) {

        // 01 - AuthenticationManager is used to authenticate the user
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authReq.getEmail(),
                authReq.getPassword()
        ));

        /* 02 - SecurityContextHolder is used to allows the rest of the application to know
        that the user is authenticated and can use user data from Authentication object */
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 03 - Generate the token based on email and secret key
        String token = jwtTokenProvider.generateToken(authentication);

        // 04 - Return the token to controller
        return token;
    }

    @Override
    public UserResDTO register(UserReqDTO userReqDTO) {
        if (userRepository.existsByUsername(userReqDTO.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByEmail(userReqDTO.getEmail())) {
            throw new RuntimeException("Email already in use");
        }

        var role = new Role();
        role.setName("ROLE_USER");

        var newUser = new User(
                userReqDTO.getUsername(),
                passwordEncoder.encode(userReqDTO.getPassword()),
                userReqDTO.getEmail(),
                List.of(role)
        );

        try {
            User savedUser = userRepository.save(newUser);
            return modelMapper.map(savedUser, UserResDTO.class);
        } catch (DataIntegrityViolationException ex) {
            throw new RuntimeException("Database error: " + ex.getMostSpecificCause().getMessage());
        }
    }
}