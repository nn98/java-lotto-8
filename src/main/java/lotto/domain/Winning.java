package lotto.domain;

import java.util.Arrays;

public enum Winning {

    LOSING(0,false, 0, "꽝"),
    FIFTH(3,false, 5000, "3개 일치"),
    FOURTH(4,false, 50000, "4개 일치"),
    THIRD(5,false, 1500000, "5개 일치"),
    SECOND(5,true, 30000000, "5개 일치, 보너스 볼 일치"),
    FIRST(6,false, 2000000000, "6개 일치");

    private final int matchCount;
    private final boolean isBonusNumberMatched;
    private final int prize;
    private final String description;

    Winning(int matchCount, boolean isBonusNumberMatched, int prize, String description) {
        this.matchCount = matchCount;
        this.isBonusNumberMatched = isBonusNumberMatched;
        this.prize = prize;
        this.description = description;
    }

    public static Winning valueOf(int matchCount, boolean isBonusNumberMatched) {
        return Arrays.stream(Winning.values())
                .filter(winning -> winning.matchCount == matchCount)
                .filter(winning -> winning.isBonusNumberMatched == isBonusNumberMatched)
                .findFirst()
                .orElse(LOSING);
    }

    public int calcPrize(int matchCount) {
        return this.prize * matchCount;
    }

    public String getStatisticsFormat(int count) {
        return String.format("%s (%,d원) - %d개", description, prize, count);
    }

}
