package lotto.vo;

import java.util.EnumMap;
import java.util.Map;

public class WinningStat {
    private final Map<Rank, Integer> result;

    public WinningStat() {
        this.result = new EnumMap<>(Rank.class);
        initializeResult();
    }

    private void initializeResult() {
        result.put(Rank.FIRST, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.FIFTH, 0);
    }

    public void addRank(Rank rank) {
        if (rank.isWinning()) {
            result.put(rank, result.get(rank) + 1);
        }
    }

    public int getCount(Rank rank) {
        return result.get(rank);
    }

    public double calculateProfitRate(int purchaseAmount) {
        return (double) getTotalPrize() / purchaseAmount * 100;
    }

    public int getTotalPrize() {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}