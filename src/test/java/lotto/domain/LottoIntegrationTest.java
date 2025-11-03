package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 통합 테스트")
class LottoIntegrationTest {

    @DisplayName("로또 생성 및 당첨 번호 검증")
    @Test
    void 로또_생성_및_당첨_번호_검증() {
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        Winning winning = winningNumbers.determineWinning(userLotto);

        assertThat(winning).isEqualTo(Winning.FIRST);
    }

    @DisplayName("보너스 번호 중복 검증")
    @Test
    void 보너스_번호_중복_검증() {
        assertThatThrownBy(() -> new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("당첨 통계 생성")
    @Test
    void 당첨_통계_생성() {
        List<Winning> winnings = Arrays.asList(Winning.FIFTH, Winning.FOURTH, Winning.LOSING);
        Statistics statistics = new Statistics(winnings);

        String result = statistics.getStatisticsToString();
        long totalPrize = statistics.calcTotalPrize();

        assertThat(result).contains("3개 일치");
        assertThat(result).contains("4개 일치");
        assertThat(totalPrize).isEqualTo(55000);
    }

    @DisplayName("수익률 계산")
    @Test
    void 수익률_계산() {
        List<Winning> winnings = Arrays.asList(Winning.FIRST);
        Statistics statistics = new Statistics(winnings);

        double yield = statistics.calcYield(1000);
        long totalPrize = statistics.calcTotalPrize();
        double expected = 100.0 * totalPrize / 1000;

        System.out.println(yield + " " + totalPrize + " " + expected);

        assertThat(yield).isEqualTo(expected);
    }

    @DisplayName("로또 일치 개수 계산")
    @Test
    void 로또_일치_개수_계산() {
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        int matchCount = userLotto.calcMatchCount(winningLotto);

        assertThat(matchCount).isEqualTo(3);
    }

    @DisplayName("사용자 로또 목록 생성")
    @Test
    void 사용자_로또_목록_생성() {
        List<Lotto> lotteries = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18))
        );
        UserLotteries userLotteries = new UserLotteries(lotteries);

        assertThat(userLotteries.size()).isEqualTo(3);
        assertThat(userLotteries.toString()).contains("[");
    }

    @DisplayName("빈 로또 목록 예외")
    @Test
    void 빈_로또_목록_예외() {
        assertThatThrownBy(() -> new UserLotteries(Arrays.asList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
