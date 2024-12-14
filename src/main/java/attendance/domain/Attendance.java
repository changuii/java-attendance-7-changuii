package attendance.domain;

import attendance.enums.AttendanceState;
import attendance.enums.DayOfWeeks;
import attendance.enums.ErrorMessage;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Attendance {
    private static final int HOUR_TO_MIN = 60;
    private static final int DAY_OF_WEEK_MIN = 1;
    private static final int DAY_OF_WEEK_MAX = 5;
    private static final LocalTime START_CAMPUS = LocalTime.of(8, 0);
    private static final int START_MONDAY_CLASS_CAMPUS = 13;
    private static final int START_CLASS_CAMPUS = 10;
    private static final int CLOSE_CLASS_CAMPUS = 18;
    private static final int LATE_TIME = 5;
    private static final int ABSENCE_TIME = 30;
    private static final LocalTime END_CAMPUS = LocalTime.of(23, 0);
    private final LocalDateTime attendanceDate;

    private Attendance(final LocalDateTime attendanceDate) {
        validateDayOfWeek(attendanceDate);
        validateTime(attendanceDate);
        this.attendanceDate = attendanceDate;
    }

    private Attendance(final LocalDate empty) {
        this.attendanceDate = LocalDateTime.of(empty, LocalTime.MAX);
    }

    public static Attendance from(final LocalDateTime attendanceDate) {
        return new Attendance(attendanceDate);
    }

    public static Attendance empty(final LocalDate localDate) {
        return new Attendance(localDate);
    }

    private void validateDayOfWeek(final LocalDateTime dateTime) {
        int dayOfWeekValue = dateTime.getDayOfWeek().getValue();
        if (dayOfWeekValue < DAY_OF_WEEK_MIN || DAY_OF_WEEK_MAX < dayOfWeekValue) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.NOT_GO_TO_SCHOOL_DAY.getMessage(),
                            dateTime.getMonth().getValue(),
                            dateTime.getDayOfMonth(),
                            DayOfWeeks.parseDayOfWeek(dateTime.getDayOfWeek())
                    ));
        }
    }

    private void validateTime(final LocalDateTime dateTime) {
        LocalTime localTime = dateTime.toLocalTime();
        if (START_CAMPUS.isAfter(localTime) || END_CAMPUS.isBefore(localTime)) {
            throw new IllegalArgumentException(ErrorMessage.CAMPUS_CLOSED.getMessage());
        }
    }

    public boolean isMatchToday(final LocalDate localDate) {
        return attendanceDate.toLocalDate().isEqual(localDate);
    }

    public LocalDateTime getAttendanceDate() {
        return attendanceDate;
    }

    public boolean isLate() {
        LocalTime localTime = attendanceDate.toLocalTime();
        int min = localTime.getMinute() * HOUR_TO_MIN;
        if (attendanceDate.getDayOfWeek() == DayOfWeek.MONDAY) {
            return min > LATE_TIME + START_MONDAY_CLASS_CAMPUS * HOUR_TO_MIN && !isAbsence();
        }
        return min > LATE_TIME + START_CLASS_CAMPUS * HOUR_TO_MIN && !isAbsence();
    }

    public boolean isAbsence() {
        LocalTime localTime = attendanceDate.toLocalTime();
        int hour = localTime.getHour();
        int min = localTime.getMinute() + hour * HOUR_TO_MIN;
        if (attendanceDate.getDayOfWeek() == DayOfWeek.MONDAY) {
            return min > ABSENCE_TIME + START_MONDAY_CLASS_CAMPUS * HOUR_TO_MIN;
        }
        return min > ABSENCE_TIME + START_CLASS_CAMPUS * HOUR_TO_MIN;
    }

    public AttendanceState getState() {
        if (isAbsence()) {
            return AttendanceState.ABSENCE;
        } else if (isLate()) {
            return AttendanceState.LATE;
        }
        return AttendanceState.ATTENDANCE;
    }

    public boolean isToday() {
        return attendanceDate.toLocalDate().isEqual(DateTimes.now().toLocalDate());
    }

    public int compareTo(final Attendance attendance) {
        return this.attendanceDate.compareTo(attendance.attendanceDate);
    }
}
