package wk.practices.clean;

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
