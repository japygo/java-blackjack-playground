package blackjack.view;

import blackjack.domain.Dealer;
import blackjack.domain.Player;
import blackjack.domain.Players;

public class ResultView {

    private ResultView() {}

    public static void showDealCards(Dealer dealer, Players players) {
        System.out.println("딜러와 pobi, jason에게 2장의 나누었습니다.");
        showCards(dealer);
        showCards(players);
    }

    public static void showCards(Player player) {
        System.out.println(player.deckInfo());
    }

    public static void showCards(Players players) {
        for (Player player : players) {
            showCards(player);
        }
    }

    public static void showResults(Players players) {
        for (Player player : players) {
            showResults(player);
        }
    }

    public static void showResults(Player player) {
        System.out.println(player.result());
    }

    public static void printCheckDealer(boolean isUnder) {
        if (isUnder) {
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
        }
    }

    public static void showFinalProfit(Dealer dealer, Players players) {
        System.out.println("## 최종 수익");
        showFinalProfit(dealer);
        showFinalProfit(players);
    }

    private static void showFinalProfit(Player player) {
        System.out.println(player.finalProfit());
    }

    private static void showFinalProfit(Players players) {
        for (Player player : players) {
            showFinalProfit(player);
        }
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
