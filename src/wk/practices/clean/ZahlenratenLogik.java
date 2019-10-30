package wk.practices.clean;

class ZahlenratenLogik {
    private static final int ANZAHL_VERSUCHE = 5;
    private final int zufallszahl;
    private int versuche;

    public ZahlenratenLogik(ZufallszahlProvider zufallszahlProvider, Schwierigkeitsgrad schwierigkeitsgradEingabe) {
        zufallszahl = zufallszahlProvider.provideValue(schwierigkeitsgradEingabe);
    }

    public Ergebnis raten(int zahl) {
        versuche++;
        final Ergebnis rueckgabe;
        if (zahl < zufallszahl) {
            rueckgabe = Ergebnis.ZU_KLEIN;
        } else if (zahl > zufallszahl) {
            rueckgabe = Ergebnis.ZU_GROSS;
        } else {
            rueckgabe = Ergebnis.RICHTIG;
        }
        if (rueckgabe != Ergebnis.RICHTIG && versuche == ANZAHL_VERSUCHE) {
            return Ergebnis.VERLOREN;
        }
        return rueckgabe;
    }

    public int getAnzahlRestversuche() {
        return ANZAHL_VERSUCHE - versuche;
    }

    public enum Ergebnis {
        ZU_KLEIN("Zahl zu klein", false),
        ZU_GROSS("Zahl zu groß", false),
        RICHTIG("Gewonnen", true),
        VERLOREN("Game Over", true);

        private final String meldung;
        private final boolean abbruch;

        Ergebnis(String meldung, boolean abbruch) {
            this.meldung = meldung;
            this.abbruch = abbruch;
        }

        public String getMeldung() {
            return meldung;
        }

        public boolean isAbbruch() {
            return abbruch;
        }
    }

    public enum Schwierigkeitsgrad {
        LEICHT(50, "Leicht", 1),
        MITTEL(100, "Mittel", 2),
        SCHWER(200, "Schwer", 3);

        private int hoechsteZahl;
        private final String anzeigetext;
        private final int eingabeWert;

        Schwierigkeitsgrad(int hoechsteZahl, String anzeigetext, int eingabeWert) {
            this.hoechsteZahl = hoechsteZahl;
            this.anzeigetext = anzeigetext;
            this.eingabeWert = eingabeWert;
        }

        public int getHoechsteZahl() {
            return hoechsteZahl;
        }

        public String getAnzeigetext() {
            return String.format("%d - %s (1 bis %d)", eingabeWert, anzeigetext, hoechsteZahl);
        }

        public int getEingabeWert() {
            return eingabeWert;
        }

        public static Schwierigkeitsgrad fromInteger(int input) {
            for (Schwierigkeitsgrad schwierigkeitsgrad : values()) {
                if (schwierigkeitsgrad.getEingabeWert() == input) {
                    return schwierigkeitsgrad;
                }
            }
            throw new RuntimeException("Ungültige Eingabe");
        }
    }
}
