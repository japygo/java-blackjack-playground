package blackjack.domain;

public interface State {
    State draw(Card card);
    State stay();
    boolean isFinished();
    Deck deck();
    double profit(double betAmount);
}
