package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private Input() {
    }

    public static String input(String message) {
        System.out.println(message);

        return Console.readLine();
    }

    public static String inputPurchaseAmount() {
        String input = Input.input(Input.INPUT_MONEY_MESSAGE);

        return input;
    }

    public static String inputWinningNumber() {
        System.out.println();
        String input = Input.input(Input.INPUT_WINNING_NUMBER_MESSAGE);

        return input;
    }

    public static String inputBonusNumber() {
        System.out.println();
        String input = Input.input(Input.INPUT_BONUS_NUMBER_MESSAGE);

        return input;
    }
}
