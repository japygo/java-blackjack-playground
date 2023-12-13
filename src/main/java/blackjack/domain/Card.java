package blackjack.domain;

public class Card {
    private final Suit suit;
    private final Denomination denomination;

    public Card(Suit suit, Denomination denomination) {
        this.suit = suit;
        this.denomination = denomination;
    }

    public int score() {
        return denomination.score();
    }

    public boolean isAce() {
        return denomination.isAce();
    }

    public String info() {
        return denomination.label() + suit.label();
    }
}
