package wk.practices.clean;

class ZahlenratenLogik {
    private static final int ANZAHL_VERSUCHE = 5;
    private final int zufallszahl;
    private int versuche;

    ZahlenratenLogik(ZufallszahlProvider zufallszahlProvider, Schwierigkeitsgrad schwierigkeitsgradEingabe) {
        zufallszahl = zufallszahlProvider.provideValue(schwierigkeitsgradEingabe);
    }

    Ergebnis raten(int zahl) {
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

    int getAnzahlRestversuche() {
        return ANZAHL_VERSUCHE - versuche;
    }
}

