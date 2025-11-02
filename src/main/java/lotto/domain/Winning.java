package lotto.domain;

import java.util.Arrays;

public enum Winning {

    LOSING(0,false);

    private final int matchCount;
    private final boolean isBonusNumberMatched;

    Winning(int matchCount, boolean isBonusNumberMatched) {
        this.matchCount = matchCount;
        this.isBonusNumberMatched = isBonusNumberMatched;
    }

    public static Winning valueOf(int matchCount, boolean isBonusNumberMatched) {
        return Arrays.stream(Winning.values())
                .filter(winning -> winning.matchCount == matchCount)
                .filter(winning -> winning.isBonusNumberMatched == isBonusNumberMatched)
                .findFirst()
                .orElse(LOSING);
    }

}
