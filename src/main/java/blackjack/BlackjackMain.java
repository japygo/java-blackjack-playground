package blackjack;

import blackjack.domain.Blackjack;
import blackjack.domain.Dealer;
import blackjack.domain.Player;
import blackjack.domain.Players;
import blackjack.view.InputView;
import blackjack.view.ResultView;

public class BlackjackMain {
    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        Players players = InputView.inputPlayers();
        InputView.inputBetAmount(players);

        Blackjack blackjack = new Blackjack(dealer, players);
        blackjack.start();

        ResultView.showDealCards(dealer, players);
        ResultView.printEmptyLine();

        for (Player player : players) {
            dealCard(player, blackjack);
        }
        ResultView.printEmptyLine();

        ResultView.printCheckDealer(blackjack.checkDealerCards());
        ResultView.printEmptyLine();

        ResultView.showResults(dealer);
        ResultView.showResults(players);
        ResultView.printEmptyLine();

        blackjack.checkFinalProfit();
        ResultView.showFinalProfit(dealer, players);
    }

    private static void dealCard(Player player, Blackjack blackjack) {
        while (InputView.isDealCard(player)) {
            blackjack.dealCard(player);
            ResultView.showCards(player);
            if (!player.isContinuable()) {
                break;
            }
        }
    }
}
