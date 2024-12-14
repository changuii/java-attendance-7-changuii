package attendance.enums;

public enum ErrorMessage {
    INPUT_FORMAT_INVALID("잘못된 형식을 입력하였습니다."),
    DAY_OF_WEEKS_INVALID("잘못된 요일입니다."),
    CREW_NAME_NOT_FOUND("등록되지 않은 닉네임입니다."),
    ALREADY_ATTENDANCE("이미 출석을 확인하였습니다. 필요한 경우 수정 기능을 이용해 주세요."),
    NOT_GO_TO_SCHOOL_DAY("%d월 %d일 %s은 등교일이 아닙니다."),
    CAMPUS_CLOSED("캠퍼스 운영 시간에만 출석이 가능합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}