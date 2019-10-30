package wk.practices.clean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZahlenratenLogikTest {

    @Test
    void correct() {

        final ZahlenratenLogik zahlenratenLogik = new ZahlenratenLogik(createMockedProvider(), Schwierigkeitsgrad.LEICHT);

        assertEquals(
                Ergebnis.ZU_KLEIN,
                zahlenratenLogik.raten(5)
        );

        assertEquals(
                Ergebnis.ZU_GROSS,
                zahlenratenLogik.raten(55)
        );

        assertEquals(
                Ergebnis.RICHTIG,
                zahlenratenLogik.raten(50)
        );

    }

    @Test
    void correctWithLastTry() {

        final ZahlenratenLogik zahlenratenLogik = new ZahlenratenLogik(createMockedProvider(), Schwierigkeitsgrad.LEICHT);

        assertEquals(
                Ergebnis.ZU_KLEIN,
                zahlenratenLogik.raten(5)
        );

        assertEquals(
                Ergebnis.ZU_GROSS,
                zahlenratenLogik.raten(55)
        );

        assertEquals(
                Ergebnis.ZU_KLEIN,
                zahlenratenLogik.raten(40)
        );

        assertEquals(
                Ergebnis.ZU_GROSS,
                zahlenratenLogik.raten(60)
        );

        assertEquals(
                Ergebnis.RICHTIG,
                zahlenratenLogik.raten(50)
        );

    }

    @Test
    void gameOver() {

        final ZahlenratenLogik zahlenratenLogik = new ZahlenratenLogik(createMockedProvider(), Schwierigkeitsgrad.LEICHT);

        assertEquals(
                Ergebnis.ZU_KLEIN,
                zahlenratenLogik.raten(5)
        );

        assertEquals(
                Ergebnis.ZU_GROSS,
                zahlenratenLogik.raten(55)
        );

        assertEquals(
                Ergebnis.ZU_KLEIN,
                zahlenratenLogik.raten(40)
        );

        assertEquals(
                Ergebnis.ZU_GROSS,
                zahlenratenLogik.raten(60)
        );

        assertEquals(
                Ergebnis.VERLOREN,
                zahlenratenLogik.raten(30)
        );

    }

    private ZufallszahlProvider createMockedProvider() {
        return new ZufallszahlProvider() {
            @Override
            public int provideValue(Schwierigkeitsgrad schwierigkeitsgrad) {
                return 50;
            }
        };
    }

}