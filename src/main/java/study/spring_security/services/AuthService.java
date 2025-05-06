package study.spring_security.services;

import study.spring_security.DTOs.AuthReq;
import study.spring_security.DTOs.UserReqDTO;
import study.spring_security.DTOs.UserResDTO;

public interface AuthService {
    String login(AuthReq authReq);
    UserResDTO register(UserReqDTO userReqDTO);
}