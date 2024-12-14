package attendance.view;

import attendance.domain.Attendance;
import attendance.domain.Crew;
import attendance.enums.AttendanceState;
import attendance.enums.DayOfWeeks;
import attendance.enums.ExpulsionState;
import attendance.enums.OutputMessage;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OutputView {
    private static final String LOCAL_TIME_PATTERN = "HH:mm";
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(LOCAL_TIME_PATTERN);

    public void printTodayAndFunctionIntroduce() {
        LocalDate today = DateTimes.now().toLocalDate();
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
        if (localTime.equals(LocalTime.MAX)) {
            return OutputMessage.EMPTY_ATTENDANCE.toString();
        }
        return localTime.format(TIME_FORMATTER);
    }


    public void printInputCrewNameUpdateTimeIntroduce() {
        print(OutputMessage.INPUT_CREW_NAME_UPDATE_TIME_INTRODUCE);
    }

    public void printUpdateAttendance(final LocalDateTime before, final LocalTime after,
                                      final AttendanceState beforeState, final AttendanceState afterState) {
        printWithOutLineBreak(OutputMessage.ATTENDANCE_TIME, before.getMonth().getValue(),
                before.getDayOfMonth(), DayOfWeeks.parseDayOfWeek(before.getDayOfWeek()),
                formatAttendanceTimeByStatus(before.toLocalTime(), beforeState), beforeState.getState());
        print(OutputMessage.UPDATE_RESULT, after.format(TIME_FORMATTER), afterState.getState());
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

    public void printAttendanceQueryResult(final int attendanceCount, final int lateCount, final int absenceCount,
                                           final ExpulsionState expulsionState) {
        print(OutputMessage.CREW_ATTENDANCE_RESULT, attendanceCount, lateCount, absenceCount);
        if(expulsionState != ExpulsionState.EMPTY){
            print(expulsionState.getState() + " " + "대상자입니다.");
        }
    }

    public void printExpulsionTitle() {
        print(OutputMessage.EXPULSION_TITLE);
    }

    public void printExpulsionRow(final List<Crew> crews) {
        crews.forEach(this::printCrewExpulsion);
    }

    private void printCrewExpulsion(final Crew crew) {
        print(OutputMessage.EXPLUSION_ROW, crew.getName(), crew.calculateCountAbsence(), crew.calculateCountLate(),
                crew.getExplsionState());
    }

    private void print(final Object message, final Object... values) {
        System.out.println(formatMessage(message.toString(), values));
    }

    private void printWithOutLineBreak(final Object message, final Object... values) {
        System.out.print(formatMessage(message.toString(), values));
    }

    private String formatMessage(final Object formatMessage, final Object... values) {
        return String.format(formatMessage.toString(), values);
    }

    public void printErrorMessage(final IllegalArgumentException customException) {
        print(customException.getMessage());
    }
}
