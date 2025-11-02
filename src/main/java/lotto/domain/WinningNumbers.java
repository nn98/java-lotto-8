package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.lotto = new Lotto(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public Winning determineWinning(Lotto userLotto) {
        return null;
    }

}
