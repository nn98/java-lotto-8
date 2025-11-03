package lotto.presentation.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        return parsePositiveInteger(readLine());
    }

    public List<Integer> readWinningNumbers() {
        String input = readLine();
        return parseNumbers(input);
    }

    private List<Integer> parseNumbers(String input) {
        String[] tokens = validate(input);
        return Arrays.stream(tokens)
                .map(String::trim)
                .map(this::parsePositiveInteger)
                .collect(Collectors.toList());
    }

    private String[] validate(String input) {
        String[] tokens = splitTokensIfValid(input);
        validateDuplicated(tokens);
        return tokens;
    }

    private String[] splitTokensIfValid(String input) {
        String[] tokens = input.split(",");
        if (tokens.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS.getMessage());
        }
        return tokens;
    }

    private void validateDuplicated(String[] tokens) {
        Set<String> numbers = new HashSet<>(Arrays.asList(tokens));
        if (numbers.size() != tokens.length) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS.getMessage());
        }
    }

    private int parsePositiveInteger(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number < 1) {
                throw new IllegalArgumentException(ErrorMessage.NON_POSITIVE_INPUT.getMessage());
            }
            return number;
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_INPUT.getMessage());
        }
    }

}
