package attendance.view;

import attendance.enums.AttendanceState;
import attendance.enums.DayOfWeeks;
import attendance.enums.OutputMessage;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class OutputView {
    private static final String LOCAL_TIME_PATTERN = "HH:mm";
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(LOCAL_TIME_PATTERN);

    public void printTodayAndFunctionIntroduce() {
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        print(OutputMessage.TODAY_AND_FUNCTION_INTRODUCE, month, day, DayOfWeeks.parseDayOfWeek(dayOfWeek));
    }

    public void printFunctionChoiceIntroduce() {
        print(OutputMessage.FUNCTION_CHOICE_INTRODUCE);
    }

    public void printInputCrewNameIntroduce() {
        print(OutputMessage.INPUT_CREW_NAME_INTRODUCE);
    }

    public void printInputGoToSchoolTimeIntroduce() {
        print(OutputMessage.INPUT_GO_TO_SCHOOL_TIME_INTRODUCE);
    }

    public void printAttendanceTime(final LocalDateTime attendanceTime, final AttendanceState state) {
        print(OutputMessage.ATTENDANCE_TIME, attendanceTime.getMonth().getValue(),
                attendanceTime.getDayOfMonth(), DayOfWeeks.parseDayOfWeek(attendanceTime.getDayOfWeek()),
                formatAttendanceTimeByStatus(attendanceTime.toLocalTime(), state), state.getState());
    }

    private String formatAttendanceTimeByStatus(final LocalTime localTime, final AttendanceState attendanceState) {
        if (AttendanceState.ABSENCE == attendanceState) {
            return OutputMessage.EMPTY_ATTENDANCE.toString();
        }
        return localTime.format(TIME_FORMATTER);
    }


    public void printInputCrewNameUpdateTimeIntroduce() {
        print(OutputMessage.INPUT_CREW_NAME_UPDATE_TIME_INTRODUCE);
    }

    public void printInputUpdateDayIntroduce() {
        print(OutputMessage.INPUT_UPDATE_DAY_INTRODUCE);
    }

    public void printInputUpdateTimeIntroduce() {
        print(OutputMessage.INPUT_UPDATE_TIME_INTRODUCE);
    }

    public void printAttendanceQueryTitle(final String name) {
        print(OutputMessage.ATTENDANCE_QUERY_TITLE, name);
    }

    public void printAttendanceQueryResult(final int attendanceCount, final int lateCount, final int absenceCount) {
        print(OutputMessage.CREW_ATTENDANCE_RESULT, attendanceCount, lateCount, absenceCount);
    }

    private void print(final Object message, final Object... values) {
        System.out.println(formatMessage(message.toString(), values));
    }

    private String formatMessage(final Object formatMessage, final Object... values) {
        return String.format(formatMessage.toString(), values);
    }
}
