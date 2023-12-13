package blackjack.domain;

import blackjack.view.InputView;
import blackjack.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BlackjackGame {
    public static final String PLAYER_NAME_DELIMITER = ",";
    public static final int INIT_DRAW_CARD_NUMBER = 2;

    private final Deck deck;
    private final Dealer dealer;
    private Players players;

    public BlackjackGame() {
        this.deck = generateDeck();
        this.dealer = new Dealer();
    }

    private Deck generateDeck() {
        List<Card> cards = new ArrayList<>();

        for (Denomination denomination : Denomination.values()) {
            Arrays.stream(Suit.values()).forEach(suit -> cards.add(new Card(suit, denomination)));
        }

        Collections.shuffle(cards);

        return new Deck(cards);
    }

    public void play() {
        inputPlayers();

        inputBetAmount();

        ResultView.printDrawInitCard(dealer, players);
        drawInitCard();
        ResultView.printDeckInfo(dealer, players);

        drawCard();

        ResultView.printResult(dealer, players);

        checkWinner();
        ResultView.printFinalProfit(dealer, players);
    }

    private void inputPlayers() {
        String playerNames = InputView.inputPlayers();
        players = new Players(
                Arrays.stream(playerNames.split(PLAYER_NAME_DELIMITER))
                        .map(Player::new)
                        .collect(Collectors.toList())
        );
        ResultView.printEmptyLine();
    }

    private void inputBetAmount() {
        for (Player player : players) {
            int betAmount = InputView.inputBetAmount(player);
            player.setBetAmount(betAmount);
            ResultView.printEmptyLine();
        }
    }

    private void drawInitCard() {
        for (int i = 0; i < INIT_DRAW_CARD_NUMBER; i++) {
            draw(dealer);
            players.forEach(this::draw);
        }
    }

    private void draw(Gamer gamer) {
        gamer.draw(deck.deal());
    }

    private void drawCard() {
        players.forEach(this::drawCard);
        ResultView.printEmptyLine();

        if (dealer.isDrawable()) {
            draw(dealer);
            ResultView.printDrawCard(dealer);
        }
        ResultView.printEmptyLine();
    }

    private void drawCard(Player player) {
        while (!player.isFinished()) {
            boolean isDraw = InputView.inputDrawCard(player);
            drawCard(player, isDraw);
            ResultView.printDeckInfo(player);
        }
    }

    private void drawCard(Player player, boolean isDraw) {
        if (isDraw) {
            draw(player);
            return;
        }
        player.stay();
    }

    private void checkWinner() {
        players.forEach(this::checkWinner);
    }

    private void checkWinner(Player player) {
        if (dealer.isBust()) {
            player.stay();
            return;
        }

        if (player.isBust()) {
            dealer.addBetAmount(player);
            return;
        }

        if (player.isBlackjack()) {
            if (dealer.isBlackjack()) {
                player.stay();
                return;
            }
            player.blackjack();
            return;
        }

        if (dealer.deckSum() < player.deckSum()) {
            player.stay();
            return;
        }

        player.bust();
        dealer.addBetAmount(player);
    }
}
