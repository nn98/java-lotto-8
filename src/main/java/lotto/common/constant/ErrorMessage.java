package lotto.common.constant;

public enum ErrorMessage {

    INVALID_INPUT("[ERROR] 입력값은 공백이 아니어야 합니다."),
    NON_POSITIVE_INPUT("[ERROR] 입력값은 양의 정수여야 합니다."),
    NON_NUMERIC_INPUT("[ERROR] 입력값은 숫자여야 합니다."),

    INVALID_AMOUNT("[ERROR] 구입금액은 양의 정수여야 합니다."),
    INDIVISIBLE_AMOUNT("[ERROR] 구입금액은 1000으로 나누어 떨어지는 값이어야 합니다."),

    INVALID_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 양의 정수여야 합니다."),
    INVALID_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATED_NUMBER("[ERROR] 로또 번호는 중복되지 않는 값이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
