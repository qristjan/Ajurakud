package ajurakudroot.here_be_spring_web_app.controller;

import ajurakudroot.here_be_spring_web_app.service.ApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

    private final ApiService apiService;

    public AppController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/lul")
    public String lul() {
        return "lul";
    }

    @GetMapping("/api/v1/lul/{id}")
    public String lulById() throws RuntimeException {
        throw new RuntimeException("get exceptioned");
    }

    @PostMapping("/api/v1/words/process")
    public List<String> processWords(@RequestBody List<String> words) {
        return apiService.processWords(words);
    }

}