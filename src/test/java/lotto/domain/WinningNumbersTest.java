package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinningNumbersTest {

    @DisplayName("당첨 번호 6개와 보너스 번호 1개로 당첨 번호를 생성한다")
    @Test
    void 당첨_번호_6개와_보너스_번호_1개로_당첨_번호를_생성한다() {
        assertDoesNotThrow(() ->
                new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7)
        );
    }

    @DisplayName("당첨 번호가 6개 미만이면 예외가 발생한다")
    @Test
    void 당첨_번호가_6개_미만이면_예외가_발생한다() {
        assertThatThrownBy(() ->
                new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5), 7)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("6개");
    }

    @DisplayName("당첨 번호가 6개 초과면 예외가 발생한다")
    @Test
    void 당첨_번호가_6개_초과면_예외가_발생한다() {
        assertThatThrownBy(() ->
                new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 8)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("6개");
    }

    @DisplayName("당첨 번호에 중복이 있으면 예외가 발생한다")
    @Test
    void 당첨_번호에_중복이_있으면_예외가_발생한다() {
        assertThatThrownBy(() ->
                new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 5), 7)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("중복");
    }

    @DisplayName("당첨 번호가 범위를 벗어나면 예외가 발생한다")
    @Test
    void 당첨_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() ->
                new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 46), 7)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다")
    @Test
    void 보너스_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() ->
                new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 46)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() ->
                new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 6)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("일치 개수에 따라 올바른 등급을 반환한다")
    @ParameterizedTest
    @CsvSource({
            "1,2,3,4,5,6, FIRST",
            "1,2,3,4,5,7, SECOND",
            "1,2,3,4,5,8, THIRD",
            "1,2,3,4,10,11, FOURTH",
            "1,2,3,10,11,12, FIFTH",
            "1,2,10,11,12,13, LOSING",
            "10,11,12,13,14,15, LOSING"
    })
    void 일치_개수에_따라_올바른_등급을_반환한다(
            int n1, int n2, int n3, int n4, int n5, int n6, Winning expected) {
        WinningNumbers winningNumbers = new WinningNumbers(
                Arrays.asList(1, 2, 3, 4, 5, 6), 7
        );
        Lotto userLotto = new Lotto(Arrays.asList(n1, n2, n3, n4, n5, n6));

        Winning winning = winningNumbers.determineWinning(userLotto);

        assertThat(winning).isEqualTo(expected);
    }

}
