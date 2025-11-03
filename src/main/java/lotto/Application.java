package lotto;

import lotto.presentation.controller.LottoController;
import lotto.presentation.view.InputView;
import lotto.presentation.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoController controller = new LottoController(inputView, outputView);
        controller.run();
        inputView.close();
    }

}
