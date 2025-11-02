package lotto.presentation.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.constant.ErrorMessage;

public class InputView {

    public String readLine() {
        String line = Console.readLine();
        if (line.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        return line;
    }

    public int readPositiveInt() {
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

    public List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        return parseNumbers(input);
    }

    private List<Integer> parseNumbers(String input) {
        validateNotBlank(input);

        String[] tokens = input.split(",");
        return Arrays.stream(tokens)
                .map(String::trim)
                .map(this::parseInteger)
                .collect(Collectors.toList());
    }

    private int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_INPUT.getMessage());
        }
    }

    private void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

}
