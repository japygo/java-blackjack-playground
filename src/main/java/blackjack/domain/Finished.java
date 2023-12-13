package blackjack.domain;

public abstract class Finished extends Started {

    protected Finished(Deck deck) {
        super(deck);
    }

    abstract double earningRate();

    @Override
    public State draw(Card card) {
        throw new IllegalArgumentException("카드를 뽑을 수 없습니다.");
    }

    @Override
    public State stay() {
        throw new IllegalArgumentException("게임이 종료되었습니다.");
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public double profit(double betAmount) {
        return betAmount * earningRate();
    }
}
