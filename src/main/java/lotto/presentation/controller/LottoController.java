package lotto.presentation.controller;

import java.util.List;
import lotto.common.constant.ErrorMessage;
import lotto.presentation.view.InputView;
import lotto.presentation.view.OutputView;
import lotto.service.LottoService;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = new LottoService();
    }

    public void run() {
        generateUserLotteries();
        generateWinningNumbers();
        determineUserLotteries();
    }

    private void generateUserLotteries() {
        int amount = readUserInputAmount();
        issuanceLottoByAmount(amount);
        noticePurchaseResult(amount / 1000, lottoService.getUserLotteriesToString());
    }

    private int readUserInputAmount() {
        try {
            outputView.printInputAmount();
            return validAmount(inputView.readPositiveInt());
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception);
            return readUserInputAmount();
        }
    }

    private int validAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INDIVISIBLE_AMOUNT.getMessage());
        }
        return amount;
    }

    private void issuanceLottoByAmount(int amount) {
        lottoService.issuanceLotteries(amount);

    }

    private void noticePurchaseResult(int amount, String lotteriesToString) {
        outputView.printPurchasedLotteries(amount, lotteriesToString);
    }

    private void generateWinningNumbers() {
        List<Integer> winningNumbers = readUserInputWinningNumbers();
        int bonusNumber = readUserInputBonusNumber();
        lottoService.generateWinningNumbers(winningNumbers, bonusNumber);
    }

    private int readUserInputBonusNumber() {
        outputView.printInputBonusNumber();
        return inputView.readPositiveInt();
    }

    private List<Integer> readUserInputWinningNumbers() {
        outputView.printInputWinningNumbers();
        return inputView.readWinningNumbers();
    }

    private void determineUserLotteries() {
        lottoService.determineEveryLotteries();
    }

}
