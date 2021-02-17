package does_it_blend;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class InternetBlender extends Blender {

    public InternetBlender(String name) {
        super(name);
    }

    @Override
    public void job() {
        try {
            URL url = new URL("http://www.randomtext.me/api/");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            con.disconnect();

            String text = new Gson().fromJson(content.toString(), JsonObject.class).get("text_out").getAsString();

            System.out.println(text);
        } catch (IOException e) {
            System.out.println("Sometimes blenders do not work.");
        }
    }

    @Override
    public void finished() {
        System.out.printf("InternetBlender %s finished%n", getName());
    }
}
