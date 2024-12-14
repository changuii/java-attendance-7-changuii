package attendance.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Crew {
    private final String name;
    private final List<Attendance> attendances;

    private Crew(final String name) {
        this.name = name;
        this.attendances = new ArrayList<>();
    }

    public static Crew from(final String name) {
        return new Crew(name);
    }

    public boolean matchName(final String crewName) {
        return name.equals(crewName);
    }

    public void additionAttendances(final LocalDateTime localDateTime) {
        attendances.add(Attendance.from(localDateTime));
    }

    public Attendance attendance(final LocalTime goToSchoolTime) {
        Attendance attendance = Attendance.from(LocalDateTime.of(LocalDate.of(2024, 12, 13), goToSchoolTime));
        attendances.add(attendance);
        return attendance;
    }

    public boolean containsTodayAttendance() {
        LocalDate today = LocalDate.now();
        return attendances.stream()
                .anyMatch(attendance -> attendance.isMatchToday(today));
    }

}
