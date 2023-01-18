import utilita.Sound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Screen extends JFrame implements ActionListener {
    private final JTextField console;

    public Screen() {
        this.setSize(1440,900);
        this.console = new JTextField();
        console.setBounds(570,600,300,300);
        console.setBackground(new Color(0, 0, 0));
        console.setForeground(new Color(255, 215, 0));
        console.setFont(new Font("Arial",Font.BOLD,24));
        console.setOpaque(true);
        console.addActionListener(this);
        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.gray);
        this.add(console);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        var s = console.getText();
        switch (s) {
            case "fairy" -> {
                Sound.stopAll();
                Sound bleep = new Sound("./sounds/music/mainMenuMusic.wav");
                bleep.play();
            }
            case "woods" -> {
                Sound.stopAll();
                Sound bleep = new Sound("./sounds/music/faronWoods.wav");
                bleep.play();
            }
            case "evangelion" -> {
                Sound.stopAll();
                Sound bleep = new Sound("./sounds/music/roflanMusic.wav");
                bleep.play();
            }
            case "stream" -> {
                Sound.stopAll();
                Sound bleep = new Sound("./sounds/music/bloodyStream.wav");
                bleep.play();
            }
            case "stop" -> {
                Sound.stopAll();
            }
            case "exit" -> {
                Sound bloop = new Sound("./sounds/soundEffects/cancelChoice.wav");
                bloop.play();
                try {
                    TimeUnit.MILLISECONDS.sleep(3000);
                    System.exit(0);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
            default -> {
                Sound bloop = new Sound("./sounds/soundEffects/choose.wav");
                bloop.play();
            }
        }
    }

    public static void main(String[] args) {
    }
}
