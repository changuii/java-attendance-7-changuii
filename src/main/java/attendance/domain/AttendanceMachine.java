package attendance.domain;

import attendance.enums.ErrorMessage;
import attendance.enums.ExpulsionState;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceMachine {
    private final List<Crew> crews;

    private AttendanceMachine(final List<Crew> crews) {
        this.crews = crews;
        crews.forEach(crew -> crew.fillNotHaveAttendances());
    }

    public static AttendanceMachine from(final List<Crew> crews) {
        return new AttendanceMachine(crews);
    }

    public boolean containsCrewName(final String name) {
        return crews.stream()
                .anyMatch(crew -> crew.matchName(name));
    }

    public Attendance attendanceByNameAndTime(final String name, final LocalTime goToSchoolTime) {
        Crew crew = getCrewByName(name);
        return crew.attendance(goToSchoolTime);
    }

    public boolean isAttendancedTodayByName(final String name) {
        Crew crew = getCrewByName(name);
        return crew.containsTodayAttendance();
    }

    public Crew getCrewByName(final String name) {
        return crews.stream()
                .filter(crew -> crew.matchName(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.CREW_NAME_NOT_FOUND.getMessage()));
    }

    public Attendance updateAttendanceByNameAndDay(final String name, final int day, final LocalTime updateTime) {
        if (day > LocalDate.now().getMonthValue()) {
            throw new IllegalArgumentException(ErrorMessage.FUTURE_ATTENDANCE_UPDATE.getMessage());
        }
        Crew crew = getCrewByName(name);
        return crew.updateByDayAndTime(day, updateTime);
    }

    public List<Crew> getExpulsionCrews() {
        return crews.stream()
                .filter(crew -> crew.getExplsionState() != ExpulsionState.EMPTY)
                .sorted(Crew::compareTo)
                .collect(Collectors.toList());
    }

    public Attendance getByNameAndDay(final String name, final int day) {
        return getCrewByName(name).getByDay(day);
    }
}
