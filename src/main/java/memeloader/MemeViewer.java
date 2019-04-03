package memeloader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
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

        java.util.List<String> urls = MemeService.getMemes().getUrls();

        if (urls != null) {
            int loopCounter = urls.size() > 20 ? 20 : urls.size();
            for (int i = 0; i < loopCounter; i++) {
                new MemeViewer(urls.get(i)).setVisible(true);
            }
        }
    }


}
