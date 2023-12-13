package blackjack.domain;

public class Dealer extends AbstractGamer {
    private static final String DEALER_NAME = "딜러";
    public static final int UNDER_NUMBER = 16;

    public Dealer() {
        super(DEALER_NAME);
    }

    public boolean isDrawable() {
        return deckSum() <= UNDER_NUMBER;
    }

    public void addBetAmount(Player player) {
        setBetAmount(getBetAmount() + player.getBetAmount());
    }
}
