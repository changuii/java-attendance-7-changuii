package attendance.enums;

public enum OutputMessage {
    TODAY_AND_FUNCTION_INTRODUCE("오늘은 %d월 %d일 %s입니다. 기능을 선택해 주세요."),
    FUNCTION_CHOICE_INTRODUCE(
            "1. 출석 확인\n"
                    + "2. 출석 수정\n"
                    + "3. 크루별 출석 기록 확인\n"
                    + "4. 제적 위험자 확인\n"
                    + "Q. 종료"
    );
    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

