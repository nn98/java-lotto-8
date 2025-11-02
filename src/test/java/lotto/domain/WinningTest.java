package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningTest {

    @DisplayName("당첨 번호 일치 수와 보너스 번호 일치 여부로 순위를 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "2, false, LOSING",
            "1, false, LOSING",
            "0, false, LOSING"
    })
    void 당첨_번호_일치_수와_보너스_번호_일치_여부로_순위를_반환한다(int matchCount, boolean isBonusNumberMatched, Winning winning) {
        Winning winningTest = Winning.valueOf(matchCount, isBonusNumberMatched);
        assertThat(winningTest).isEqualTo(winning);
    }
}
