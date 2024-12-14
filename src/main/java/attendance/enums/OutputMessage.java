package attendance.enums;

public enum OutputMessage {
    TODAY_AND_FUNCTION_INTRODUCE("오늘은 %d월 %d일 %s입니다. 기능을 선택해 주세요.");
    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

