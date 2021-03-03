package ajurakudroot.memeloader;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataDTO {

    private List<MemeDTO> memes;

    public List<MemeDTO> getMemes() {
        return memes;
    }

    public void setMemes(List<MemeDTO> memes) {
        this.memes = memes;
    }
}
