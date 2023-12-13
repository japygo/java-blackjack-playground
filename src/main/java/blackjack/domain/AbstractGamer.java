package blackjack.domain;

public abstract class AbstractGamer implements Gamer {
    private final String name;
    private final Deck deck;
    private State state;
    private double betAmount;

    protected AbstractGamer(String name) {
        this.name = name;
        this.deck = new Deck();
        this.state = new Hit(deck);
    }

    public void setBetAmount(double betAmount) {
        this.betAmount = betAmount;
    }

    public double getBetAmount() {
        return betAmount;
    }

    public boolean isBust() {
        return deck.isBust();
    }

    public boolean isBlackjack() {
        return deck.isBlackjack();
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String deckInfo() {
        return deck.info();
    }

    @Override
    public void draw(Card card) {
        state = state.draw(card);
    }

    @Override
    public void stay() {
        state = new Stay(deck);
    }

    public void blackjack() {
        state = new Blackjack(deck);
    }

    public void bust() {
        state = new Bust(deck);
    }

    @Override
    public boolean isFinished() {
        return state.isFinished();
    }

    @Override
    public String profit() {
        return name + ": " + state.profit(betAmount);
    }

    @Override
    public int deckSum() {
        return deck.sum();
    }
}
