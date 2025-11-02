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
        int matchCount = calcMatchCount(userLotto);
        boolean isBonusNumberMatched = isBonusNumberMatched(userLotto);
        return Winning.valueOf(matchCount, isBonusNumberMatched);
    }

    private int calcMatchCount(Lotto userLotto) {
        return userLotto.calcMatchCount(this.lotto);
    }

    private boolean isBonusNumberMatched(Lotto userLotto) {
        return userLotto.contains(this.bonusNumber);
    }

}
