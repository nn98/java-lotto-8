package lotto.presentation.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.constant.ErrorMessage;

public class InputView {

    public static String readLine() {
        String line = Console.readLine();
        if (line.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        return line;
    }

    public static int readPositiveInt() {
        try {
            int input = Integer.parseInt(readLine());
            if (input < 1) {
                throw new IllegalArgumentException(ErrorMessage.NON_POSITIVE_INPUT.getMessage());
            }
            return input;
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_INPUT.getMessage());
        }
    }

}
