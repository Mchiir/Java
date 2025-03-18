package mchiir.testdocker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Base {
    @GetMapping("/")
    public String index() {
        return "Welcome to dockerized application.";
    }
}
