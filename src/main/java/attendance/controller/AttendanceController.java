package attendance.controller;

import attendance.component.CrewsGenerator;
import attendance.domain.Crew;
import attendance.handler.RetryHandler;
import attendance.view.InputView;
import attendance.view.OutputView;
import java.util.List;

public class AttendanceController {
    private static final String FUNCTION_ATTENDANCE = "1";
    private static final String FUNCTION_ATTENDANCE_UPDATE = "2";
    private static final String FUNCTION_CREW_ATTENDANCE_QUERY = "3";
    private static final String FUNCTION_CREW_EXPULSION_QUERY = "4";
    private static final String FUNCTION_QUIT = "Q";
    private final CrewsGenerator crewsGenerator;
    private final InputView inputView;
    private final OutputView outputView;
    private final RetryHandler retryHandler;

    public AttendanceController(final CrewsGenerator crewsGenerator, final InputView inputView,
                                final OutputView outputView, final RetryHandler retryHandler) {
        this.crewsGenerator = crewsGenerator;
        this.inputView = inputView;
        this.outputView = outputView;
        this.retryHandler = retryHandler;
    }

    public void run() {
        List<Crew> crews = crewsGenerator.generate();
    }

    private boolean start(final List<Crew> crews) {
        outputView.printTodayAndFunctionIntroduce();
        outputView.printFunctionChoiceIntroduce();
        String function = inputView.inputChoiceFunction();
        if (function.equals(FUNCTION_ATTENDANCE)) {

        } else if (function.equals(FUNCTION_ATTENDANCE_UPDATE)) {

        } else if (function.equals(FUNCTION_CREW_ATTENDANCE_QUERY)) {

        } else if (function.equals(FUNCTION_CREW_EXPULSION_QUERY)) {

        }
        return function.equals(FUNCTION_QUIT);
    }
}
