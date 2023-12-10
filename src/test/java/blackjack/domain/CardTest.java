package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardTest {

    @DisplayName("카드를 생성한다")
    @Test
    void create() {
        Card actual = new Card(CardType.HEART, CardNumber.FIVE);
        assertThat(actual).isEqualTo(new Card(CardType.HEART, CardNumber.FIVE));
    }

    @DisplayName("카드 타입을 가져온다")
    @Test
    void getLabel() {
        Card card = new Card(CardType.HEART, CardNumber.FIVE);
        String actual = card.typeLabel();
        assertThat(actual).isEqualTo("하트");
    }

    @DisplayName("카드 숫자를 가져온다")
    @Test
    void getNumber() {
        Card card = new Card(CardType.HEART, CardNumber.FIVE);
        int actual = card.numberValue();
        assertThat(actual).isEqualTo(5);
    }
}