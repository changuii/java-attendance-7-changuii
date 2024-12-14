package attendance.controller;

import attendance.component.CrewsGenerator;
import attendance.domain.Crew;
import attendance.view.InputView;
import java.util.List;

public class AttendanceController {
    private final CrewsGenerator crewsGenerator;
    private final InputView inputView;

    public AttendanceController(final CrewsGenerator crewsGenerator, final InputView inputView) {
        this.crewsGenerator = crewsGenerator;
        this.inputView = inputView;
    }

    public void run() {
        List<Crew> crews = crewsGenerator.generate();
        inputView.inputChoiceFunction();
    }
}
