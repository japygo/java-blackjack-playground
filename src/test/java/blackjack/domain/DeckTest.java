package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DeckTest {

    @DisplayName("중복된 카드를 추가하면 에러가 발생한다")
    @Test
    void addCardException() {
        Deck deck = new Deck();
        Card card = new Card(CardType.HEART, CardNumber.FIVE);
        deck.addCard(card);
        assertThatThrownBy(() -> deck.addCard(card)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("카드를 뽑는다")
    @Test
    void dealCard() {
        Deck deck = new Deck();
        deck.addCard(new Card(CardType.HEART, CardNumber.FIVE));
        deck.addCard(new Card(CardType.DIAMOND, CardNumber.ACE));
        deck.addCard(new Card(CardType.CLOVER, CardNumber.EIGHT));

        assertThat(deck.dealCard()).isEqualTo(new Card(CardType.CLOVER, CardNumber.EIGHT));
        assertThat(deck.dealCard()).isEqualTo(new Card(CardType.DIAMOND, CardNumber.ACE));
        assertThat(deck.dealCard()).isEqualTo(new Card(CardType.HEART, CardNumber.FIVE));
    }

    @DisplayName("카드 뽑을때 덱이 비어있으면 에러가 발생한다")
    @Test
    void dealCardException() {
        Deck deck = new Deck();
        assertThatThrownBy(deck::dealCard).isInstanceOf(IndexOutOfBoundsException.class);
    }
}