package lotto.presentation.controller;

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
        int amount = readUserInputAmount();
        issuanceLottoByAmount(amount);
        noticePurchaseResult(amount / 1000, lottoService.getUserLotteriesToString());
    }
    private void issuanceLottoByAmount(int amount) {
        lottoService.issuanceLotteries(amount);

    }

    private int readUserInputAmount() {
        try {
            outputView.printInputAmount();
            return validAmount(InputView.readPositiveInt());
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

    private void noticePurchaseResult(int amount, String lotteriesToString) {
        OutputView.printPurchasedLotteries(amount, lotteriesToString);
    }

}
