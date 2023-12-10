package blackjack.domain;

import java.util.function.Function;
import java.util.function.IntFunction;

public enum ResultType {
    BLACKJACK_WIN(player -> (int) (player.getBetAmount() * 1.5)),
    WIN(Player::getBetAmount),
    DRAW(Player::getBetAmount),
    LOSE(player -> player.getBetAmount() * -1),
    ;

    private final Function<Player, Integer> checkResult;

    ResultType(Function<Player, Integer> checkResult) {
        this.checkResult = checkResult;
    }

    public int checkResult(Player player) {
        return checkResult.apply(player);
    }
}
