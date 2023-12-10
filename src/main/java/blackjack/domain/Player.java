package blackjack.domain;

public class Player {
    private final String name;
    private final Deck deck;
    private int betAmount;
    private ResultType resultType;

    public Player(String name) {
        this.name = name;
        this.deck = new Deck();
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }

    public void takeCard(Card card) {
        deck.addCard(card);
    }

    public String getName() {
        return name;
    }

    public int getBetAmount() {
        return betAmount;
    }

    public int getCardSum() {
        return deck.sum();
    }

    public int getResult() {
        return Blackjack.BLACKJACK - getCardSum();
    }

    public boolean isContinuable() {
        return getCardSum() < Blackjack.BLACKJACK;
    }

    public String deckInfo() {
        return name + "카드: " + deck.info();
    }

    public String result() {
        return deckInfo() + " - 결과: " + deck.sum();
    }

    public boolean isBlackjack() {
        return deck.isBlackjack();
    }

    public boolean isLose() {
        return getCardSum() > Blackjack.BLACKJACK;
    }

    public void win() {
        if (deck.isBlackjack()) {
            resultType = ResultType.BLACKJACK_WIN;
            return;
        }
        resultType = ResultType.WIN;
    }

    public void draw() {
        resultType = ResultType.DRAW;
    }

    public void lose() {
        resultType = ResultType.LOSE;
    }

    public String finalProfit() {
        return name + ": " + resultType.checkResult(this);
    }
}
