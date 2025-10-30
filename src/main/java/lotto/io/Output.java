package lotto.io;

import lotto.vo.LogMessageLevel;
import lotto.vo.Lotto;
import lotto.vo.Wallet;

public class Output {
    public static final String PURCHASE_COUNT_FORMAT = "%d개를 구매했습니다.";
    public static final String WINNING_STATISTICS = "당첨 통계";
    public static final String STATISTICS_SEPARATOR = "---";
    public static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    private Output() {
    }

    public static void printPurchaseResult(Wallet wallet) {
        System.out.println();
        System.out.println(String.format(Output.PURCHASE_COUNT_FORMAT, wallet.getLottoCount()));
        printLottos(wallet);
    }

    private static void printLottos(Wallet wallet) {
        for (Lotto lotto : wallet.getLottos()) {
            System.out.println(lotto);
        }
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(LogMessageLevel.ERROR.getLevel() + e.getMessage());
    }
}
