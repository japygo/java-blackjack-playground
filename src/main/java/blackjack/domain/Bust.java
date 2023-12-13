package blackjack.domain;

public class Bust extends Finished {

    protected Bust(Deck deck) {
        super(deck);
    }

    @Override
    double earningRate() {
        return -1;
    }
}
