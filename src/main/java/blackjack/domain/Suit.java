package blackjack.domain;

public enum Suit {
    CLUBS("클로버"),
    DIAMONDS("다이아몬드"),
    HEARTS("하트"),
    SPADES("스페이드"),
    ;

    private final String label;

    Suit(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
