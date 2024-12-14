package attendance.config;

import attendance.component.CrewsGenerator;
import attendance.component.CsvFileParser;
import attendance.component.FileParser;
import attendance.controller.AttendanceController;

public abstract class AttendanceConfig {
    public static AttendanceController createController() {
        return new AttendanceController(createCrewsGenerator());
    }

    private static CrewsGenerator createCrewsGenerator() {
        return new CrewsGenerator(createFileParser());
    }

    private static FileParser createFileParser() {
        return new CsvFileParser();
    }
}
