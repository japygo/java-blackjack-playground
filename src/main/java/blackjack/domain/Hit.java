package blackjack.domain;

public class Hit extends Running {

    protected Hit(Deck deck) {
        super(deck);
    }

    @Override
    public State draw(Card card) {
        Deck deck = deck();
        deck.receive(card);
        if (deck.isBust()) {
            return new Bust(deck);
        }
        return new Hit(deck);
    }

    @Override
    public State stay() {
        return new Stay(deck());
    }
}
