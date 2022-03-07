package study.exception;

public class OperatorException extends RuntimeException {
    private ErrorCode errorCode;
    private String message;

    public OperatorException(ErrorCode errorCode) {
        this(errorCode, errorCode.getMessage());
    }

    public OperatorException(ErrorCode errorCode, String customMessage) {
        super(customMessage);
        this.errorCode = errorCode;
        this.message = customMessage;
    }
}
