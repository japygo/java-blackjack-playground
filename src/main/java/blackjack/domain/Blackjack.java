package blackjack.domain;

public class Blackjack {
    public static final int BLACKJACK = 21;

    private final Dealer dealer;
    private final Players players;
    private final Deck deck;

    public Blackjack(Dealer dealer, Players players) {
        this.dealer = dealer;
        this.players = players;
        this.deck = new Deck();
    }

    public void start() {
        initDeck();
        shuffleDeck();
        dealCardsTwice();
    }

    private void initDeck() {
        for (CardType type : CardType.values()) {
            for (CardNumber number : CardNumber.values()) {
                deck.addCard(new Card(type, number));
            }
        }
    }

    private void shuffleDeck() {
        deck.shuffle();
    }

    public void dealCard(Player player) {
        player.takeCard(deck.dealCard());
    }

    private void dealCardsTwice() {
        dealCards();
        dealCards();
    }

    private void dealCards() {
        dealCard(dealer);
        players.getPlayers().forEach(this::dealCard);
    }

    public boolean checkDealerCards() {
        if (dealer.isDealable()) {
            dealCard(dealer);
            return true;
        }
        return false;
    }

    public void checkFinalProfit() {
        if (dealer.isLose()) {
            dealer.lose();
            players.forEach(Player::draw);
            return;
        }

        Player winner = dealer;
        boolean isDealerBlackjack = dealer.isBlackjack();
        int dealerAmount = players.getPlayers().stream().mapToInt(Player::getBetAmount).sum();
        players.forEach(Player::lose);

        for (Player player : players) {
            if (player.isLose()) {
                continue;
            }

            if (player.getResult() == winner.getResult()) {
                player.win();
                dealerAmount -= player.getBetAmount();
            }

            if (player.getResult() < winner.getResult()) {
                player.win();
                dealerAmount -= player.getBetAmount();

                winner.lose();
                dealerAmount += winner.getBetAmount();

                winner = player;
            }

            if (isDealerBlackjack) {
                player.draw();
            }
        }

        dealer.setBetAmount(dealerAmount);
        dealer.draw();
    }
}
