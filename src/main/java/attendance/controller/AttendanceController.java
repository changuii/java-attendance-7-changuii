package attendance.controller;

import attendance.component.CrewsGenerator;
import attendance.domain.Crew;
import attendance.view.InputView;
import attendance.view.OutputView;
import java.util.List;

public class AttendanceController {
    private final CrewsGenerator crewsGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public AttendanceController(final CrewsGenerator crewsGenerator, final InputView inputView,
                                final OutputView outputView) {
        this.crewsGenerator = crewsGenerator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<Crew> crews = crewsGenerator.generate();
        outputView.printTodayAndFunctionIntroduce();
        inputView.inputChoiceFunction();
    }
}
