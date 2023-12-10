package blackjack.view;

import blackjack.domain.Player;
import blackjack.domain.Players;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    private InputView() {}

    public static Players inputPlayers() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String input = scanner.next().trim();
        ResultView.printEmptyLine();
        String[] names = input.split(DELIMITER);
        List<Player> players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name));
        }
        return new Players(players);
    }

    public static void inputBetAmount(Players players) {
        for (Player player : players) {
            inputBetAmount(player);
        }
    }

    private static void inputBetAmount(Player player) {
        System.out.println(player.getName() + "의 배팅 금액은?");
        int betAmount = scanner.nextInt();
        player.setBetAmount(betAmount);
        ResultView.printEmptyLine();
    }

    public static boolean isDealCard(Player player) {
        System.out.println(player.getName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        String answer = scanner.next();
        return !answer.equals("n");
    }

}
