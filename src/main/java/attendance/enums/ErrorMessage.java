package attendance.enums;

public enum ErrorMessage {
    INPUT_FORMAT_INVALID("잘못된 형식을 입력하였습니다."),
    DAY_OF_WEEKS_INVALID("잘못된 요일입니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}