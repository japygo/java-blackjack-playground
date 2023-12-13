package blackjack.domain;

public class Blackjack extends Finished {

    protected Blackjack(Deck deck) {
        super(deck);
    }

    @Override
    double earningRate() {
        return 1.5;
    }
}
