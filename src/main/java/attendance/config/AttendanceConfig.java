package attendance.config;

import attendance.component.CrewsGenerator;
import attendance.component.CsvFileParser;
import attendance.component.FileParser;
import attendance.controller.AttendanceController;
import attendance.view.InputValidator;
import attendance.view.InputView;

public abstract class AttendanceConfig {
    public static AttendanceController createController() {
        return new AttendanceController(createCrewsGenerator(), createInputView());
    }

    private static CrewsGenerator createCrewsGenerator() {
        return new CrewsGenerator(createFileParser());
    }

    private static FileParser createFileParser() {
        return new CsvFileParser();
    }

    private static InputView createInputView() {
        return new InputView(new InputValidator());
    }
}
