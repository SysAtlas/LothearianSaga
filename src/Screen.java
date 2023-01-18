import utilita.Sound;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Screen extends JFrame implements ActionListener {
    private final JTextField console;
    private final JLabel background;
    private final JTextArea textField;


    public Screen() {
        this.setSize(1440,900);

        this.console = new JTextField();
        this.textField = new JTextArea();
        this.background = new JLabel();

        console.setBounds(1024,600,416,300);
        console.setBackground(new Color(0, 0, 0));
        console.setForeground(new Color(255, 215, 0));
        console.setFont(new Font("Arial",Font.BOLD,24));
        console.setBorder(new BasicBorders.ButtonBorder(Color.yellow,Color.orange,Color.yellow,Color.orange));
        console.setOpaque(true);
        console.addActionListener(this);

        background.setBounds(0,0,1024,900);
        background.setBorder(new BasicBorders.ButtonBorder(Color.yellow,Color.orange,Color.yellow,Color.orange));

        JLabel character = new JLabel();
        character.setBounds(100,0,1024,900);
        character.setIcon(new ImageIcon("./images/reikabezfona.png"));
        background.add(character);


        textField.setBounds(1024,0,416,600);
        textField.setBackground(new Color(0, 0, 0));
        textField.setForeground(new Color(255, 215, 0));
        textField.setFont(new Font("Arial",Font.BOLD,24));
        textField.setBorder(new BasicBorders.ButtonBorder(Color.yellow,Color.orange,Color.yellow,Color.orange));
        textField.setOpaque(true);
        textField.setLineWrap(true);
        textField.setWrapStyleWord(true);
        textField.setEditable(false);

        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.gray);
        this.add(console);
        this.add(background);
        this.add(textField);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        var s = console.getText();
        switch (s) {
            case "fairy" -> {
                Sound.stopAll();
                Sound bleep = new Sound("./sounds/music/mainMenuMusic.wav");
                textField.setText("There is no image of a fairy. Enjoy the relaxing music instead!");
                bleep.play();
            }
            case "woods" -> {
                Sound.stopAll();
                Sound bleep = new Sound("./sounds/music/faronWoods.wav");
                this.setBackground("./images/takayanVillage.png");
                textField.setText("Enjoy this image of an AI-generated village!");
                bleep.play();
            }
            case "evangelion" -> {
                Sound.stopAll();
                Sound bleep = new Sound("./sounds/music/roflanMusic.wav");
                textField.setText("There is no image of Rei Ayanami. Enjoy the cool music instead!");
                bleep.play();
            }
            case "stream" -> {
                Sound.stopAll();
                Sound bleep = new Sound("./sounds/music/bloodyStream.wav");
                this.setBackground("./images/sword.png");
                textField.setText("Enjoy this image of an AI-generated sword!");
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

    public void setBackground(String filePath) {
        this.background.setIcon(new ImageIcon(filePath));
    }

    public static void main(String[] args) {
        new Screen();
    }
}
