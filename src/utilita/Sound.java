package utilita;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Sound {
    private Clip clip;
    private FloatControl volumeControl;
    private static final ArrayList<Sound> initSounds = new ArrayList<>();
    public Sound(String pathName) {
        File soundFile = new File(pathName);
        try {
            AudioInputStream soundStream = AudioSystem.getAudioInputStream(soundFile);
            this.clip = AudioSystem.getClip();
            this.clip.open(soundStream);
            this.volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            initSounds.add(this);
        } catch (Exception e) {
            System.out.println("Warning: Couldn't create Sound object!");
        }
    }

    public void play() {
        try {
            clip.setFramePosition(0);
            clip.start();
        } catch (Exception e) {
            System.out.println("Warning: Music not playing!");
        }
    }

    public void loop() {
        try {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("Warning: Music not looping!");
        }
    }

    public void stop() {
        if (!clip.isOpen()) {
            System.out.println("utilita.Sound not open!");
            return;
        }
        try {
            clip.stop();
        } catch (Exception e) {
            System.out.println("Warning: Music can't be stopped!");
        }
    }

    public static void stopAll() {
        for (var sound : initSounds) {
            sound.stop();
        }
    }

    public void adjustSound() {
        if (this.volumeControl.getValue() >= -70.0f) {
            this.volumeControl.setValue(this.volumeControl.getValue() - 10.0f);
        }
    }
}
