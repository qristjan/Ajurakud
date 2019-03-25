package memeloader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MemeViewer extends JFrame {

    public MemeViewer(String url) throws IOException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MEME");

        java.net.URL meme_url = new URL(url);
        Image meme = ImageIO.read(meme_url);

        ImageIcon image = new ImageIcon(meme);
        JLabel label = new JLabel(image);
        JScrollPane scrollPane = new JScrollPane(label);
        add(scrollPane, BorderLayout.CENTER);
        pack();
    }

    public static void main(String[] args) throws IOException {
        String url = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/Felis_silvestris_silvestris_small_gradual_decrease_of_quality.png/240px-Felis_silvestris_silvestris_small_gradual_decrease_of_quality.png";
        new MemeViewer(url).setVisible(true);
    }


}
