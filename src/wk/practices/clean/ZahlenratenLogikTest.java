package wk.practices.clean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZahlenratenLogikTest {

    @Test
    public void correct() {

        final ZahlenratenLogik zahlenratenLogik = new ZahlenratenLogik(createMockedProvider(), ZahlenratenLogik.Schwierigkeitsgrad.LEICHT);

        assertEquals(
                ZahlenratenLogik.Ergebnis.ZU_KLEIN,
                zahlenratenLogik.raten(5)
        );

        assertEquals(
                ZahlenratenLogik.Ergebnis.ZU_GROSS,
                zahlenratenLogik.raten(55)
        );

        assertEquals(
                ZahlenratenLogik.Ergebnis.RICHTIG,
                zahlenratenLogik.raten(50)
        );

    }

    @Test
    public void correctWithLastTry() {

        final ZahlenratenLogik zahlenratenLogik = new ZahlenratenLogik(createMockedProvider(), ZahlenratenLogik.Schwierigkeitsgrad.LEICHT);

        assertEquals(
                ZahlenratenLogik.Ergebnis.ZU_KLEIN,
                zahlenratenLogik.raten(5)
        );

        assertEquals(
                ZahlenratenLogik.Ergebnis.ZU_GROSS,
                zahlenratenLogik.raten(55)
        );

        assertEquals(
                ZahlenratenLogik.Ergebnis.ZU_KLEIN,
                zahlenratenLogik.raten(40)
        );

        assertEquals(
                ZahlenratenLogik.Ergebnis.ZU_GROSS,
                zahlenratenLogik.raten(60)
        );

        assertEquals(
                ZahlenratenLogik.Ergebnis.RICHTIG,
                zahlenratenLogik.raten(50)
        );

    }

    @Test
    public void gameOver() {

        final ZahlenratenLogik zahlenratenLogik = new ZahlenratenLogik(createMockedProvider(), ZahlenratenLogik.Schwierigkeitsgrad.LEICHT);

        assertEquals(
                ZahlenratenLogik.Ergebnis.ZU_KLEIN,
                zahlenratenLogik.raten(5)
        );

        assertEquals(
                ZahlenratenLogik.Ergebnis.ZU_GROSS,
                zahlenratenLogik.raten(55)
        );

        assertEquals(
                ZahlenratenLogik.Ergebnis.ZU_KLEIN,
                zahlenratenLogik.raten(40)
        );

        assertEquals(
                ZahlenratenLogik.Ergebnis.ZU_GROSS,
                zahlenratenLogik.raten(60)
        );

        assertEquals(
                ZahlenratenLogik.Ergebnis.VERLOREN,
                zahlenratenLogik.raten(30)
        );

    }

    private ZufallszahlProvider createMockedProvider() {
        return new ZufallszahlProvider() {
            @Override
            public int provideValue(ZahlenratenLogik.Schwierigkeitsgrad schwierigkeitsgrad) {
                return 50;
            }
        };
    }

}