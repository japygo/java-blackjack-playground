package blackjack.domain;

public class Dealer extends Player {
    private static final String NAME = "딜러";
    private static final int UNDER_NUMBER = 16;

    public Dealer() {
        super(NAME);
    }

    public boolean isDealable() {
        return getCardSum() <= UNDER_NUMBER;
    }
}
