package study.spring_security.services;

import study.spring_security.DTOs.UserReqDTO;
import study.spring_security.DTOs.UserResDTO;

import java.util.List;

public interface UserService {
    UserResDTO register(UserReqDTO userReqDTO);
    List<UserResDTO> getAllUsers();
    UserResDTO getUserById(Long id);
    UserResDTO updateUser(Long id, UserReqDTO userReqDTO);
    void deleteUser(Long id);
}