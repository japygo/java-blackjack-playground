package blackjack.domain;

public abstract class Started implements State {
    private final Deck deck;

    protected Started(Deck deck) {
        this.deck = deck;
    }

    @Override
    public Deck deck() {
        return deck;
    }
}
