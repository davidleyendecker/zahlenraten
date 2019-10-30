package wk.practices.clean;

import java.util.concurrent.ThreadLocalRandom;

public class DefaultZufallszahlProvider implements ZufallszahlProvider {
    @Override
    public int provideValue(Schwierigkeitsgrad schwierigkeitsgrad) {
        return ThreadLocalRandom.current().nextInt(1, schwierigkeitsgrad.getHoechsteZahl() + 1);
    }
}
