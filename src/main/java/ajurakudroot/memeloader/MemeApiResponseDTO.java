package ajurakudroot.memeloader;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemeApiResponseDTO {

    private String success;
    private DataDTO data;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public List<String> getUrls() {
        if (this.data == null || this.data.getMemes() == null) {
            return null;
        }
        return this.data.getMemes().stream().map(MemeDTO::getUrl).collect(Collectors.toList());
    }


}
