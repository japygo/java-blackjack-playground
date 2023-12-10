package blackjack.domain;

public class Card {
    private final CardType type;
    private final CardNumber number;

    public Card(CardType type, CardNumber number) {
        this.type = type;
        this.number = number;
    }

    public String typeLabel() {
        return type.getLabel();
    }

    public int numberValue() {
        return number.getValue();
    }

    public String info() {
        return numberValue() + typeLabel();
    }

    public boolean isAce() {
        return number.isAce();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (type != card.type) return false;
        return number == card.number;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }
}
