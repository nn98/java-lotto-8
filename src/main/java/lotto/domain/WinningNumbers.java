package lotto.domain;

import java.util.List;
import lotto.common.constant.ErrorMessage;

public class WinningNumbers {

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.lotto = new Lotto(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
        validate(this.lotto, this.bonusNumber);
    }

    private void validate(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

    public Winning determineWinning(Lotto userLotto) {
        return null;
    }

}
