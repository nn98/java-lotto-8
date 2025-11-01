package lotto.common.constant;

public enum ErrorMessage {
    INVALID_AMOUNT("[ERROR] 구입금액은 양의 정수로 입력해 주세요."),
    INDIVISIBLE_AMOUNT("[ERROR] 구입금액은 1000으로 나누어 떨어지는 값으로 입력해 주세요."),

    INVALID_NUMBER("[ERROR] 로또 번호는 1~45 사이의 양의 정수로 입력해 주세요."),
    DUPLICATED_NUMBER("[ERROR] 로또 번호는 중복되지 않는 값으로 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
