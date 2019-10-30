package wk.practices.clean;

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
