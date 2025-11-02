package lotto.domain;

import java.util.HashSet;
import java.util.List;
import lotto.common.constant.ErrorMessage;

public class Lotto {

    private final HashSet<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        HashSet<LottoNumber> lottoNumbers = createLottoNumbers(numbers);
        checkDuplicated(numbers, lottoNumbers);
        this.numbers = lottoNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.getMessage());
        }
    }

    private void checkDuplicated(List<Integer> numbers, HashSet<LottoNumber> lottoNumbers) {
        if (numbers.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

    private HashSet<LottoNumber> createLottoNumbers(List<Integer> numbers) {
        HashSet<LottoNumber> lottoNumbers = new HashSet<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }

    public int calcMatchCount(Lotto targetLotto) {
        return (int)this.numbers.stream()
                .filter(targetLotto::contains)
                .count();
    }

}
