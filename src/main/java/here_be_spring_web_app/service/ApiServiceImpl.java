package here_be_spring_web_app.service;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApiServiceImpl implements ApiService {

    public List<String> processWords(List<String> words) {
        return CollectionUtils.emptyIfNull(words).stream().map(this::processWord).collect(Collectors.toList());
    }

    private String processWord(String word) {
        return word + "_";
    }

}
