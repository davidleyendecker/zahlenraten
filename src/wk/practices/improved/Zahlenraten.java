package wk.practices.improved;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Zahlenraten {
    private static final int ANZAHL_VERSUCHE = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int zufallszahl = 0;
        int versuche = 0;
        String eingabe = "";
        boolean spielZuEnde = false;
        while (!eingabe.toLowerCase().equals("q")) {

            if (zufallszahl == 0) {
                System.out.println("Bitte wählen Sie einen Schwierigkeitsgrad");
                System.out.println("1 - Einfach (1 bis 50)");
                System.out.println("2 - Mittel (1 bis 100)");
                System.out.println("3 - Schwer (1 bis 200)");

                eingabe = scanner.next();
                if (eingabe.equals("1")) {
                    zufallszahl = getZufallszahl(50);
                } else if (eingabe.equals("2")) {
                    zufallszahl = getZufallszahl(100);
                } else if (eingabe.equals("3")) {
                    zufallszahl = getZufallszahl(200);
                }
            }

            System.out.printf("Sie haben noch %d Versuche. Bitte geben Sie eine Zahl ein: ", ANZAHL_VERSUCHE - versuche);
            eingabe = scanner.next();

            try {
                int i = Integer.parseInt(eingabe);
                if (i < zufallszahl) {
                    System.out.println("Zahl zu klein");
                } else if (i > zufallszahl) {
                    System.out.println("Zahl zu groß");
                } else {
                    System.out.println("Glückwunsch");
                    spielZuEnde = true;
                }
                versuche++;
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Es sind nur Zahlen, oder q zum Beenden zulässig");
            }
            if (versuche == ANZAHL_VERSUCHE) {
                System.out.println("Game over");
                spielZuEnde = true;
            }

            if (spielZuEnde) {
                System.out.print("Möchten Sie es nochmal versuchen? (J/N)");
                eingabe = scanner.next();
                if (eingabe.toLowerCase().equals("j")) {
                    versuche = 0;
                    spielZuEnde = false;
                    zufallszahl = 0;
                } else {
                    break;
                }
            }
        }
    }

    private static int getZufallszahl(int bound) {
        return ThreadLocalRandom.current().nextInt(1, bound + 1);
    }
}
