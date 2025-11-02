package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("정상적 범위의 숫자로 로또 번호를 생성한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 30, 45})
    void 정상적_범위의_숫자로_로또_번호를_생성한다(int number) {
        // given & when
        LottoNumber lottoNumber = new LottoNumber(number);

        // then
        assertThat(lottoNumber.getNumber()).isEqualTo(number);
    }

    @DisplayName("미만값의 로또 번호를 생성하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100})
    void 미만값의_로또_번호를_생성하면_예외가_발생한다(int number) {
        // given & when & then
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("초과값의 로또 번호를 생성하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {46, 100, 999})
    void 초과값의_로또_번호를_생성하면_예외가_발생한다(int number) {
        // given & when & then
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("같은 숫자를 가진 로또 번호는 같은 객체로 판단한다")
    @Test
    void 같은_숫자를_가진_로또_번호는_같은_객체로_판단한다() {
        // given
        LottoNumber number1 = new LottoNumber(1);
        LottoNumber number2 = new LottoNumber(1);

        // when & then
        assertThat(number1).isEqualTo(number2);
    }

    @DisplayName("다른 숫자를 가진 로또 번호는 다른 객체로 판단한다")
    @Test
    void 다른_숫자를_가진_로또_번호는_다른_객체로_판단한다() {
        // given
        LottoNumber number1 = new LottoNumber(1);
        LottoNumber number2 = new LottoNumber(2);

        // when & then
        assertThat(number1).isNotEqualTo(number2);
    }

}
