package blackjack.domain;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {
    private static final int BLACK_JACK_NUMBER = 21;
    private static final int ADD_ACE_SCORE = 10;

    private final Deque<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = new ArrayDeque<>(cards);
    }

    public Deck() {
        cards = new ArrayDeque<>();
    }

    public Card deal() {
        if (cards.isEmpty()) {
            throw new IndexOutOfBoundsException("덱이 비었습니다.");
        }
        return cards.pop();
    }

    public void receive(Card card) {
        if (cards.contains(card)) {
            throw new IllegalArgumentException("이미 추가된 카드입니다.");
        }
        cards.add(card);
    }

    public int sum() {
        int sum = cards.stream().mapToInt(Card::score).sum();
        if (containAce() && sum + ADD_ACE_SCORE < BLACK_JACK_NUMBER) {
            sum += ADD_ACE_SCORE;
        }
        return sum;
    }

    private boolean containAce() {
        return cards.stream().anyMatch(Card::isAce);
    }

    public int count() {
        return cards.size();
    }

    public boolean isBust() {
        return sum() > BLACK_JACK_NUMBER;
    }

    public boolean isBlackjack() {
        return count() == 2 && sum() == BLACK_JACK_NUMBER;
    }

    public String info() {
        return cards.stream().map(Card::info).collect(Collectors.joining(", "));
    }
}
