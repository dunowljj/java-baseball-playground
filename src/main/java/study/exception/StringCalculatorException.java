package study.exception;

public class StringCalculatorException extends RuntimeException{
    private ErrorCode errorCode;
    private String message;

    public StringCalculatorException(ErrorCode errorCode) {
        this(errorCode , errorCode.getMessage());
    }

    public StringCalculatorException(ErrorCode errorCode, String customMessage) {
        super(customMessage);
        this.errorCode = errorCode;
        this.message = customMessage;
    }
}
