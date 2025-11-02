package lotto.domain;

import java.util.Arrays;

public enum Winning {

    LOSING(0,false, 0),
    FIFTH(3,false, 5000),
    FOURTH(4,false, 50000),
    THIRD(5,false, 1500000),
    SECOND(5,true, 30000000),
    FIRST(6,false, 2000000000);

    private final int matchCount;
    private final boolean isBonusNumberMatched;
    private final int prize;

    Winning(int matchCount, boolean isBonusNumberMatched, int prize) {
        this.matchCount = matchCount;
        this.isBonusNumberMatched = isBonusNumberMatched;
        this.prize = prize;
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

}
