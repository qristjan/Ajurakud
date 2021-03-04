package game;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static fizzbuzz.Printer.kirjuta;

public class Game {

    Game() {
        JFrame frame = new JFrame();
        frame.setTitle("Braincells");
        frame.setSize(600, 400);
        frame.setVisible(true);

        JButton button = new JButton("X");
        button.setBounds(20, 20, 100, 100);

        button.addActionListener(e -> new VanishOxyAction("muusika.wav"));

        frame.add(button);
    }

    public static void main(String[] args) {
        new Game();
    }

}

class VanishOxyAction extends AbstractAction {

    VanishOxyAction(String filePath) {
        muusika(filePath);
    }

    private void muusika(String filePath) {
        try {
            //hacks
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/java/game" + filePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(1);
        } catch (UnsupportedAudioFileException e) {
            kirjuta("Seda muusikat ma ei mängi!");
        } catch (LineUnavailableException e) {
            kirjuta("Liin on kinni!");
        } catch (IOException e) {
            kirjuta("InpuuterOutpuuter VIGA!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kirjuta("Korras");
    }
}
