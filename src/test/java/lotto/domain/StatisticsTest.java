package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatisticsTest {

    @DisplayName("당첨 통계 생성 - LOSING 제외")
    @Test
    void 당첨_통계_LOSING_제외() {
        List<Winning> winnings = Arrays.asList(
                Winning.FIFTH,
                Winning.FIFTH,
                Winning.LOSING,
                Winning.LOSING
        );
        Statistics statistics = new Statistics(winnings);

        String result = statistics.getStatisticsToString();
        assertThat(result).contains("3개 일치");
        assertThat(result).doesNotContain("꽝");
    }

    @DisplayName("총 상금 계산")
    @Test
    void 총_상금_계산() {
        List<Winning> winnings = Arrays.asList(
                Winning.FIRST,
                Winning.SECOND
        );
        Statistics statistics = new Statistics(winnings);

        int totalPrize = statistics.calcTotalPrize();
        int expected = 2_000_000_000 + 30_000_000;

        assertThat(totalPrize).isEqualTo(expected);
    }
}
