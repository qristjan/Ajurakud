package ajurakudroot.memeloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class MemeService {

    public static MemeApiResponseDTO getMemes() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://api.imgflip.com/get_memes");
        CloseableHttpResponse response = httpclient.execute(httpGet);
        MemeApiResponseDTO result = null;

        try {
            HttpEntity entity1 = response.getEntity();
            result = objectMapper.readValue(EntityUtils.toString(entity1), MemeApiResponseDTO.class);
            EntityUtils.consume(entity1);
        } finally {
            response.close();
        }

        return result;
    }

}
