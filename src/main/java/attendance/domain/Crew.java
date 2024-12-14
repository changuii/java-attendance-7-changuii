package attendance.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
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
        Attendance attendance = Attendance.from(LocalDateTime.of(LocalDate.now(), goToSchoolTime));
        attendances.add(attendance);
        return attendance;
    }

    public boolean containsTodayAttendance() {
        LocalDate today = LocalDate.now();
        return attendances.stream()
                .anyMatch(attendance -> attendance.isMatchToday(today));
    }

    public List<Attendance> getAttendances() {
        fillNotHaveAttendances();
        sortByAttendanceDay();
        return attendances;
    }

    private void sortByAttendanceDay() {
        Collections.sort(attendances, ((o1, o2) -> o1.compareTo(o2)));
    }

    private void fillNotHaveAttendances() {
        sortByAttendanceDay();
        for (int day = 1; day < LocalDate.now().getDayOfMonth(); day++) {
            LocalDate localDate = LocalDate.of(2024, 12, day);
            if (localDate.getDayOfWeek().getValue() > 5 || day == 25 || containsAttendanceByLocalDate(localDate)) {
                continue;
            }
            attendances.add(Attendance.empty(localDate));
        }
    }

    public int calculateCountAttendance() {
        return (int) attendances.stream()
                .filter(attendance -> !attendance.isLate())
                .filter(attendance -> !attendance.isAbsence())
                .count();
    }

    public int calculateCountLate() {
        return (int) attendances.stream()
                .filter(attendance -> attendance.isLate())
                .count();
    }

    public int calculateCountAbsence() {
        return (int) attendances.stream()
                .filter(attendance -> attendance.isAbsence())
                .count();
    }

    private boolean containsAttendanceByLocalDate(final LocalDate localDate) {
        return attendances.stream()
                .anyMatch(attendance -> attendance.isMatchToday(localDate));
    }

}
