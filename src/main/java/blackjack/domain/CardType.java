package blackjack.domain;

public enum CardType {
    DIAMOND("다이아몬드"),
    SPADE("스페이드"),
    HEART("하트"),
    CLOVER("클로버"),
    ;

    private final String label;

    CardType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
