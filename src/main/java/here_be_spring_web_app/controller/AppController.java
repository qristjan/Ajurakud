package here_be_spring_web_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/lul")
    public String lul() {
        return "lul";
    }

    @GetMapping("/api/v1/lul/{id}")
    public String lulById() throws RuntimeException {
        throw new RuntimeException("get exceptioned");
    }

}