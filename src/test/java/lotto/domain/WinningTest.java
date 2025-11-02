package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    
    @DisplayName("지정되지 않은 값으로 valueOf 시 예외 대신 LOSING 을 반환한다.")
    @Test
    void 지정되지_않은_값으로_valueOf_시_예외_대신_LOSING_을_반환한다() {
        Winning winningTest = Winning.valueOf(7, true);
        assertThat(winningTest).isEqualTo(Winning.LOSING);
    }
    
    @DisplayName("일등 당첨 로또와 삼등 당첨 로또의 상금의 합을 반환한다.")
    @Test
    void 일등_당첨_로또와_삼등_당첨_로또의_상금의_합을_반환한다() {
        int prizeSum = Winning.valueOf(6, false).calcPrize(1)
                + Winning.valueOf(5, false).calcPrize(1);
        int expectedPrizeSum = 2000000000 + 1500000;
        assertThat(prizeSum).isEqualTo(expectedPrizeSum);
    }
    
}
