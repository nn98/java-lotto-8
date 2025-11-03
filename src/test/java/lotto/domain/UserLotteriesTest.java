package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserLotteriesTest {

    @DisplayName("빈 로또 리스트 예외")
    @Test
    void 빈_로또_리스트_예외() {
        assertThatThrownBy(() -> new UserLotteries(Arrays.asList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또 개수 반환")
    @Test
    void 로또_개수_반환() {
        List<Lotto> lotteries = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18))
        );

        UserLotteries userLotteries = new UserLotteries(lotteries);
        assertThat(userLotteries.size()).isEqualTo(3);
    }

    @DisplayName("로또 문자열 변환")
    @Test
    void 로또_문자열_변환() {
        List<Lotto> lotteries = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );

        UserLotteries userLotteries = new UserLotteries(lotteries);
        String result = userLotteries.toString();

        assertThat(result).contains("[");
        assertThat(result).contains("]");
    }

}
