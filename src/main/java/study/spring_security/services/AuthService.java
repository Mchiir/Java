package study.spring_security.services;

import study.spring_security.DTOs.AuthReq;

public interface AuthService {
    String login(AuthReq authReq);
}