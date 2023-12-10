package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {
    private static final String DELIMITER = ", ";

    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void addCard(Card card) {
        if (cards.contains(card)) {
            throw new IllegalArgumentException("이미 추가된 카드입니다.");
        }
        cards.add(card);
    }

    public Card dealCard() {
        if (cards.isEmpty()) {
            throw new IndexOutOfBoundsException("덱이 비었습니다.");
        }
        return cards.remove(cards.size() - 1);
    }

    public int sum() {
        int sum = cards.stream()
                .mapToInt(Card::numberValue)
                .sum();
        boolean containAce = cards.stream().anyMatch(Card::isAce);

        if (containAce && (sum > Blackjack.BLACKJACK)) {
            sum -= 10;
        }

        return sum;
    }

    public String info() {
        return cards.stream()
                .map(Card::info)
                .collect(Collectors.joining(DELIMITER));
    }

    public boolean isBlackjack() {
        return cards.size() == 2 && sum() == Blackjack.BLACKJACK;
    }
}
