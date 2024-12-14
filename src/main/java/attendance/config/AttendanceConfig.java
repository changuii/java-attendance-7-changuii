package attendance.config;

import attendance.component.CrewsGenerator;
import attendance.component.CsvFileParser;
import attendance.component.FileParser;
import attendance.controller.AttendanceController;
import attendance.view.InputParser;
import attendance.view.InputValidator;
import attendance.view.InputView;
import attendance.view.OutputView;

public abstract class AttendanceConfig {
    public static AttendanceController createController() {
        return new AttendanceController(createCrewsGenerator(), createInputView(), new OutputView());
    }

    private static CrewsGenerator createCrewsGenerator() {
        return new CrewsGenerator(createFileParser());
    }

    private static FileParser createFileParser() {
        return new CsvFileParser();
    }

    private static InputView createInputView() {
        return new InputView(new InputValidator(), new InputParser());
    }
}
