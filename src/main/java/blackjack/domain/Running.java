package blackjack.domain;

public abstract class Running extends Started {

    protected Running(Deck deck) {
        super(deck);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public double profit(double betAmount) {
        return betAmount;
    }
}
