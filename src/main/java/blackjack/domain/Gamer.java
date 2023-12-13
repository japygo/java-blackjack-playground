package blackjack.domain;

public interface Gamer {
    String name();
    String deckInfo();
    void draw(Card card);
    void stay();
    boolean isFinished();
    String profit();
    int deckSum();

    default String info() {
        return name() + "카드: " + deckInfo();
    }

    default String result() {
        return info() + " - 결과: " + deckSum();
    }
}
