package lotto.io;

import lotto.vo.*;

public class Output {
    public static final String PURCHASE_COUNT_FORMAT = "%d개를 구매했습니다.";
    public static final String WINNING_STATISTICS = "당첨 통계";
    public static final String STATISTICS_SEPARATOR = "---";
    public static final String RANK_FORMAT = "%s (%,d원) - %d개";
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

    public static void printWinningStatistics(WinningStat result, int purchaseAmount) {
        printStatisticsHeader();
        printRankStatistics(result);
        printProfitRate(result.calculateProfitRate(purchaseAmount));
    }

    private static void printStatisticsHeader() {
        System.out.println();
        System.out.println(Output.WINNING_STATISTICS);
        System.out.println(Output.STATISTICS_SEPARATOR);
    }

    private static void printRankStatistics(WinningStat result) {
        printRank(Rank.FIFTH, result);
        printRank(Rank.FOURTH, result);
        printRank(Rank.THIRD, result);
        printRank(Rank.SECOND, result);
        printRank(Rank.FIRST, result);
    }

    private static void printRank(Rank rank, WinningStat result) {
        System.out.println(String.format(Output.RANK_FORMAT,
                rank.getDescription(),
                rank.getPrize(),
                result.getCount(rank)));
    }

    private static void printProfitRate(double profitRate) {
        System.out.println(String.format(Output.PROFIT_RATE_FORMAT, profitRate));
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(LogMessageLevel.ERROR.getLevel() + e.getMessage());
    }
}