package translaateerija;

import java.io.PrintStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Russianizer extends PrintStream {
    private final HttpClient yourmom = HttpClient.newHttpClient();

    public Russianizer() {
        super(System.out);
    }

    private String fetch_wink_wink(String kek) {
        HttpRequest cumLoad = HttpRequest.newBuilder()
                .uri(URI.create("http://hurrdurr.com"))
                .build();
        HttpResponse.BodyHandler<String> belly = HttpResponse.BodyHandlers.ofString();
        HttpResponse<String> happySmile = null;
        try {
            yourmom.sendAsync(cumLoad, belly);
            Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome start https://www.youtube.com/watch?v=UcRtFYAz2Yo"});
            return "сука, я работаю над твоим животом";
        } catch (Exception e) {
            return "чертовски мамочка, купи себе интернет";
        }
    }

    @Override
    public void print(String su_sitt_sõnum_blyat) {
        super.print(fetch_wink_wink(su_sitt_sõnum_blyat));
    }

    @Override
    public void println(String su_sitt_sõnum_blyat) {
        super.print(fetch_wink_wink(su_sitt_sõnum_blyat));
    }
}
