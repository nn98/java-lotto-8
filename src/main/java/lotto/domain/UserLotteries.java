package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.common.constant.ErrorMessage;

public class UserLotteries {

    private final List<Lotto> lotteries;

    public UserLotteries(List<Lotto> lotteries) {
        validate(lotteries);
        this.lotteries = new ArrayList<>(lotteries);
    }

    private void validate(List<Lotto> lotteries) {
        if (lotteries == null || lotteries.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.CANNOT_PURCHASE_AMOUNT.getMessage());
        }
    }

    public int size() {
        return lotteries.size();
    }

    public Lotto get(int index) {
        return lotteries.get(index);
    }

    public List<Lotto> getLotteries() {
        return Collections.unmodifiableList(lotteries);
    }
}
