package lotto.presentation.controller;

import lotto.common.constant.ErrorMessage;
import lotto.presentation.view.InputView;
import lotto.presentation.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        issuanceLottoByUserInputAmount();
    }

    private void issuanceLottoByUserInputAmount() {
        int amount = readUserInputAmount();

    }

    private int readUserInputAmount() {
        try {
            return validAmount(this.inputView.readPositiveInt());
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception);
            return readUserInputAmount();
        }
    }

    private int validAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INDIVISIBLE_AMOUNT.getMessage());
        }
        return amount;
    }

}
