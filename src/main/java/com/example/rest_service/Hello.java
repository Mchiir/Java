package com.example.rest_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/greetme")
public class Hello {
    @GetMapping(value="/{name}", produces = MediaType.TEXT_HTML_VALUE)
    public String index(@PathVariable("name") String name) {
        return "<h1>Greetings "+ name + ", welcome to Springboot services!</h1>";
    }
}