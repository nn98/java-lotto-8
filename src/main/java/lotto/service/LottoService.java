package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.UserLotteries;

public class LottoService {

    private int amount;
    private UserLotteries userLotteries;

    public LottoService() {
    }

    public void issuanceLotteries(int amount) {
        List<Lotto> lotteries = new ArrayList<>();
        for (int i = amount / 1000 ; i > 0 ; i--) {
            lotteries.add(issuanceLotto());
        }
        this.userLotteries = new UserLotteries(lotteries);
    }

    private Lotto issuanceLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public String getUserLotteriesToString() {
        return userLotteries.toString();
    }
}
