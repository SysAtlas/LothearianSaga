import utilita.Sound;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MainMenu {
    public static void mainChooser() {
        Sound mainMenuMusic = new Sound("./sounds/music/mainMenuMusic.wav");
        Sound choose = new Sound("./sounds/soundEffects/choose.wav");
        Sound exit = new Sound("./sounds/soundEffects/cancelChoice.wav");
        mainMenuMusic.loop();
        A: while (true) {
            System.out.println("\nWelcome to the magical world of text video games.\nWe hope you enjoy your stay! ^_^\n");
            System.out.println("1. New game\n2. Continue\n3. Settings\n4. Quit");
            System.out.print("Choose: ");
            Scanner sc = new Scanner(System.in);
            String response = sc.next();
            switch (response) {
                case "1":
                    choose.play();
                    continue;
                case "2":
                    choose.play();
                    continue;
                case "3":
                    choose.play();
                    settings();
                    continue;
                case "4":
                    exit.play();
                    for (int i = 0; i <= 2; i++) {
                        System.out.println(".");
                        try {
                            TimeUnit.MILLISECONDS.sleep(300);
                        } catch (Exception e) {}
                    }
                    System.out.println("See you next time!");
                    break A;
                default:
            }
        }
    }

    public static void settings() {
        System.out.println("You are now in the settings block.");
        Scanner sc = new Scanner(System.in);
        String response = sc.next();
    }
    public static void main(String[] args) {
        mainChooser();
    }
}