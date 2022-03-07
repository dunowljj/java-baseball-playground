package study.exception;

public enum ErrorCode {
    INVALID_OPERATOR("존재하지 않는 연산자입니다."),
    ARITHMETIC_BY_ZERO("0으로 나눌 수 없습니다."),
    ILLEGAL_NUMBER_FORMAT("숫자를 입력해야할 자리에 다른 값이 존재합니다."),
    INVALID_INPUT_LENGTH("입력된 문자열의 길이가 짝수입니다.");

    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}