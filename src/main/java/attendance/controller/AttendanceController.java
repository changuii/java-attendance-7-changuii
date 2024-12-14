package attendance.controller;

import attendance.component.CrewsGenerator;
import attendance.domain.Crew;
import java.util.List;

public class AttendanceController {
    private final CrewsGenerator crewsGenerator;

    public AttendanceController(final CrewsGenerator crewsGenerator) {
        this.crewsGenerator = crewsGenerator;
    }

    public void run() {
        List<Crew> crews = crewsGenerator.generate();
    }
}
