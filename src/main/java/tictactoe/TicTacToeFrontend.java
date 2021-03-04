package tictactoe;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TicTacToeFrontend {
    public static void run() throws IOException {
        URL url = TicTacToeFrontend.class.getResource("/tictactoe/fe");
        File file = new File(url.getFile());
        String dir = file.getAbsolutePath();


        String[] command = new String[]{ "bash", "-c", "" };
        ProcessBuilder pb = new ProcessBuilder(command);

        Process process = pb.start();
    }
}
