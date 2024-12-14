package attendance.enums;

public enum OutputMessage {
    TODAY_AND_FUNCTION_INTRODUCE("오늘은 %d월 %d일 %s입니다. 기능을 선택해 주세요."),
    FUNCTION_CHOICE_INTRODUCE(
            "1. 출석 확인\n"
                    + "2. 출석 수정\n"
                    + "3. 크루별 출석 기록 확인\n"
                    + "4. 제적 위험자 확인\n"
                    + "Q. 종료"
    ),
    INPUT_CREW_NAME_INTRODUCE("닉네임을 입력해 주세요."),
    INPUT_GO_TO_SCHOOL_TIME_INTRODUCE("등교 시간을 입력해 주세요."),
    INPUT_CREW_NAME_UPDATE_TIME_INTRODUCE("출석을 수정하려는 크루의 닉네임을 입력해 주세요."),
    INPUT_UPDATE_DAY_INTRODUCE("수정하려는 날짜(일)를 입력해 주세요."),
    INPUT_UPDATE_TIME_INTRODUCE("언제로 변경하겠습니까?"),
    ATTENDANCE_TIME("%d월 %d일 %s %s %s"),
    ATTENDANCE_QUERY_TITLE("이번 달 %s의 출석 기록입니다."),
    EMPTY_ATTENDANCE("--:--"),
    CREW_ATTENDANCE_RESULT(
            "출석: %d회\n"
                    + "지각: %d회\n"
                    + "결석: %d회"
    ),
    UPDATE_RESULT("-> %s %s 수정 완료!"),
    EXPULSION_TITLE("제적 위험자 조회 결과"),
    EXPLUSION_ROW("- %s: 결석 %d회, 지각 %d회 %s"),
    ;
    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

