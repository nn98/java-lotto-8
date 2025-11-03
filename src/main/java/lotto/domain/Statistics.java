package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Statistics {

    private final List<Winning> winnings;

    public Statistics(List<Winning> winnings) {
        this.winnings = winnings;
    }

    public String getStatisticsToString() {
        Map<Winning, Long> counts = buildWinningCounts();
        StringBuilder statistics = new StringBuilder();
        buildStatistics(statistics, counts);
        return statistics.toString();
    }

    private Map<Winning, Long> buildWinningCounts() {
        return winnings.stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        ));
    }

    private void buildStatistics(StringBuilder statistics, Map<Winning, Long> counts) {
        for (Winning winning : Winning.values()) {
            long count = counts.getOrDefault(winning, 0L);
            statistics.append(winning.getStatisticsFormat((int) count));
        }
    }

    private int calcTotalPrize() {
        return buildWinningCounts().entrySet()
                .stream()
                .mapToInt(
                        entry -> entry.getKey()
                                .calcPrize(
                                        entry.getValue()
                                                .intValue()
                                )
                ).sum();
    }

    public double calcProfit(int amount) {
        int totalPrize = calcTotalPrize();
        return totalPrize / (double) amount;
    }

}
