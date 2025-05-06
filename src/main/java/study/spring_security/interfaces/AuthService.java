package study.spring_security.interfaces;

import study.spring_security.DTO.AuthReq;

public interface AuthService {
    String login(AuthReq authReq);
}