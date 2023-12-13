package blackjack.view;

import blackjack.domain.BlackjackGame;
import blackjack.domain.Dealer;
import blackjack.domain.Gamer;
import blackjack.domain.Player;
import blackjack.domain.Players;

import java.util.stream.Collectors;

public class ResultView {

    private ResultView() {}

    public static void printDeckInfo(Gamer gamer) {
        System.out.println(gamer.info());
    }

    public static void printDeckInfo(Players players) {
        players.forEach(ResultView::printDeckInfo);
    }

    public static void printDeckInfo(Dealer dealer, Players players) {
        printDeckInfo(dealer);
        printDeckInfo(players);
        printEmptyLine();
    }

    public static void printDrawInitCard(Dealer dealer, Players players) {
        System.out.println(dealer.name() + "와 " +
                players.stream().map(Player::name).collect(Collectors.joining(BlackjackGame.PLAYER_NAME_DELIMITER)) +
                "에게 " + BlackjackGame.INIT_DRAW_CARD_NUMBER + "장의 나누었습니다.");
    }

    public static void printDrawCard(Dealer dealer) {
        System.out.println(dealer.name() + "는 " + Dealer.UNDER_NUMBER + "이하라 한장의 카드를 더 받았습니다.");
    }

    public static void printResult(Gamer gamer) {
        System.out.println(gamer.result());
    }

    public static void printResult(Players players) {
        players.forEach(ResultView::printResult);
    }

    public static void printResult(Dealer dealer, Players players) {
        printResult(dealer);
        printResult(players);
        printEmptyLine();
    }

    public static void printFinalProfit(Gamer gamer) {
        System.out.println(gamer.profit());
    }

    public static void printFinalProfit(Players players) {
        players.forEach(ResultView::printFinalProfit);
    }

    public static void printFinalProfit(Dealer dealer, Players players) {
        System.out.println("## 최종 수익");
        printFinalProfit(dealer);
        printFinalProfit(players);
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
