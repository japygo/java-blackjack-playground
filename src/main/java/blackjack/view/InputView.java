package blackjack.view;

import blackjack.domain.Player;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static String inputPlayers() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return SCANNER.next();
    }

    public static int inputBetAmount(Player player) {
        System.out.println(player.name() + "의 배팅 금액은?");
        return SCANNER.nextInt();
    }

    public static boolean inputDrawCard(Player player) {
        System.out.println(player.name() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        return "y".equals(SCANNER.next());
    }
}
