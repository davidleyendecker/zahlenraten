package wk.practices.clean;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Zahlenraten {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String eingabe = "";
        ZahlenratenLogik logik = null;
        while (!eingabe.toLowerCase().equals("q")) {

            if (logik == null) {
                System.out.println("Bitte wählen Sie einen Schwierigkeitsgrad");
                for (ZahlenratenLogik.Schwierigkeitsgrad schwierigkeitsgrad : ZahlenratenLogik.Schwierigkeitsgrad.values()) {
                    System.out.println(schwierigkeitsgrad.getAnzeigetext());
                }

                Integer i = getZahlEingabe(scanner);
                if(i == null) {
                    break;
                }
                ZahlenratenLogik.Schwierigkeitsgrad schwierigkeitsgrad = ZahlenratenLogik.Schwierigkeitsgrad.fromInteger(i);
                logik = new ZahlenratenLogik(new DefaultZufallszahlProvider(), schwierigkeitsgrad);
            }

            System.out.printf("Sie haben noch %d Versuche. Bitte geben Sie eine Zahl ein: ", logik.getAnzahlRestversuche());
            Integer i = getZahlEingabe(scanner);
            if(i == null) {
                break;
            }
            ZahlenratenLogik.Ergebnis ergebnis = logik.raten(i);
            System.out.println(ergebnis.getMeldung());

            if (ergebnis.isAbbruch()) {
                System.out.print("Möchten Sie es nochmal versuchen? (J/N)");
                eingabe = scanner.next();
                if (eingabe.toLowerCase().equals("j")) {
                    logik = null;
                } else {
                    break;
                }
            }
        }
    }

    private static Integer getZahlEingabe(Scanner scanner) {
        int i = 0;
        while (i == 0) {
            try {
                String eingabe = scanner.next();
                if(eingabe.equals("q")) {
                    return null;
                }
                i = Integer.parseInt(eingabe);
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe");
            }
        }
        return i;
    }
}

