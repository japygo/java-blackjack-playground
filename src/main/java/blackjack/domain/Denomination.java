package blackjack.domain;

public enum Denomination {
    ACE(1, "A"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    JACK(10, "J"),
    QUEEN(10, "Q"),
    KING(10, "K");

    private final int score;
    private final String label;

    Denomination(int score, String label) {
        this.score = score;
        this.label = label;
    }

    public int score() {
        return score;
    }

    public String label() {
        return label;
    }

    public boolean isAce() {
        return this == ACE;
    }
}