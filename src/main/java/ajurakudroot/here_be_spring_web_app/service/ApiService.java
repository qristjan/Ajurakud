package ajurakudroot.here_be_spring_web_app.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApiService {

    List<String> processWords(List<String> words);

}
