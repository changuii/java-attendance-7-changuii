package attendance.domain;

import attendance.enums.ErrorMessage;
import java.time.LocalTime;
import java.util.List;

public class AttendanceMachine {
    private final List<Crew> crews;

    private AttendanceMachine(final List<Crew> crews) {
        this.crews = crews;
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

    private Crew getCrewByName(final String name) {
        return crews.stream()
                .filter(crew -> crew.matchName(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.CREW_NAME_NOT_FOUND.getMessage()));
    }
}
