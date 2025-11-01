package lotto.common.constant;

public enum ErrorMessage {
    INVALID_AMOUNT("[ERROR] 구입금액은 양의 정수여야 합니다."),
    INDIVISIBLE_AMOUNT("[ERROR] 구입금액은 1000으로 나누어 떨어지는 값이어야 합니다."),

    INVALID_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 양의 정수여야 합니다."),
    DUPLICATED_NUMBER("[ERROR] 로또 번호는 중복되지 않는 값이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
