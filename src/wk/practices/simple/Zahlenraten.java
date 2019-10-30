package wk.practices.simple;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Zahlenraten {
    private static final int ANZAHL_VERSUCHE = 5;

    public static void main(String[] args) {
        int zufallszahl = ThreadLocalRandom.current().nextInt(1, 50 + 1);

        Scanner scanner = new Scanner(System.in);

        int versuche = 0;
        String eingabe = "";
        boolean spielZuEnde = false;
        while (!eingabe.toLowerCase().equals("q")) {
            System.out.printf("Sie haben noch %d Versuche. Bitte geben Sie eine Zahl ein: ", ANZAHL_VERSUCHE - versuche);
            eingabe = scanner.next();

            try {
                int i = Integer.parseInt(eingabe);
                if(i < zufallszahl) {
                    System.out.println("Zahl zu klein");
                } else if(i > zufallszahl) {
                    System.out.println("Zahl zu groß");
                } else {
                    System.out.println("Glückwunsch");
                    spielZuEnde = true;
                }
                versuche++;
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Es sind nur Zahlen, oder q zum Beenden zulässig");
            }
            if(versuche == ANZAHL_VERSUCHE) {
                System.out.println("Game over");
                spielZuEnde = true;
            }

            if(spielZuEnde) {
                System.out.print("Möchten Sie es nochmal versuchen? (J/N)");
                eingabe = scanner.next();
                if(eingabe.toLowerCase().equals("j")) {
                    versuche = 0;
                    spielZuEnde = false;
                } else {
                    break;
                }
            }
        }
    }
}
