package blackjack.domain;

public class Stay extends Finished {

    protected Stay(Deck deck) {
        super(deck);
    }

    @Override
    double earningRate() {
        return 1;
    }
}
