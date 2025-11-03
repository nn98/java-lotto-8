package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Statistics;
import lotto.domain.UserLotteries;
import lotto.domain.Winning;
import lotto.domain.WinningNumbers;

public class LottoService {

    private int amount;
    private UserLotteries userLotteries;
    private WinningNumbers winningNumbers;
    private List<Winning> winnings;
    private Statistics statistics;

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

    public void generateWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new WinningNumbers(winningNumbers, bonusNumber);
    }

    public void determineEveryLotteries() {
        this.winnings = new ArrayList<>();
        for(Lotto lotto : userLotteries.getLotteries()) {
            winnings.add(winningNumbers.determineWinning(lotto));
        }
        generateStatistics();
    }

    private void generateStatistics() {
        this.statistics = new Statistics(this.winnings);
    }

    public String getStatisticsToString() {
        return statistics.getStatisticsToString();
    }

}
