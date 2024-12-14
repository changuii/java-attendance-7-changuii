package attendance.domain;

import java.time.LocalDateTime;
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

}
