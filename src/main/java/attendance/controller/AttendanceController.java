package attendance.controller;

import attendance.component.CrewsGenerator;
import attendance.domain.Attendance;
import attendance.domain.AttendanceMachine;
import attendance.domain.Crew;
import attendance.enums.ErrorMessage;
import attendance.handler.RetryHandler;
import attendance.view.InputView;
import attendance.view.OutputView;
import java.time.LocalTime;

public class AttendanceController {
    private static final String FUNCTION_ATTENDANCE = "1";
    private static final String FUNCTION_ATTENDANCE_UPDATE = "2";
    private static final String FUNCTION_CREW_ATTENDANCE_QUERY = "3";
    private static final String FUNCTION_CREW_EXPULSION_QUERY = "4";
    private static final String FUNCTION_QUIT = "Q";
    private final InputView inputView;
    private final OutputView outputView;
    private final RetryHandler retryHandler;
    private final AttendanceMachine attendanceMachine;

    public AttendanceController(final CrewsGenerator crewsGenerator, final InputView inputView,
                                final OutputView outputView, final RetryHandler retryHandler) {
        attendanceMachine = AttendanceMachine.from(crewsGenerator.generate());
        this.inputView = inputView;
        this.outputView = outputView;
        this.retryHandler = retryHandler;
    }

    public void run() {
        retryHandler.retryUntilTrue(this::start);
    }

    private boolean start() {
        outputView.printTodayAndFunctionIntroduce();
        outputView.printFunctionChoiceIntroduce();
        String function = inputView.inputChoiceFunction();
        if (function.equals(FUNCTION_ATTENDANCE)) {
            attendance();
        } else if (function.equals(FUNCTION_ATTENDANCE_UPDATE)) {

        } else if (function.equals(FUNCTION_CREW_ATTENDANCE_QUERY)) {
            attendanceQuery();
        } else if (function.equals(FUNCTION_CREW_EXPULSION_QUERY)) {

        }
        return function.equals(FUNCTION_QUIT);
    }

    private void attendance() {
        outputView.printInputCrewNameIntroduce();
        String crewName = inputView.inputCrewName();
        if (!attendanceMachine.containsCrewName(crewName)) {
            throw new IllegalArgumentException(ErrorMessage.CREW_NAME_NOT_FOUND.getMessage());
        }
        if (attendanceMachine.isAttendancedTodayByName(crewName)) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_ATTENDANCE.getMessage());
        }
        outputView.printInputGoToSchoolTimeIntroduce();
        LocalTime goToSchoolTime = inputView.inputTime();
        Attendance attendance = attendanceMachine.attendanceByNameAndTime(crewName, goToSchoolTime);
        outputView.printAttendanceTime(attendance.getAttendanceDate(), attendance.getState());
    }

    private void attendanceQuery() {
        outputView.printInputCrewNameIntroduce();
        String crewName = inputView.inputCrewName();
        if (!attendanceMachine.containsCrewName(crewName)) {
            throw new IllegalArgumentException(ErrorMessage.CREW_NAME_NOT_FOUND.getMessage());
        }
        outputView.printAttendanceQueryTitle(crewName);
        Crew crew = attendanceMachine.getCrewByName(crewName);
        crew.getAttendances().stream()
                .filter(attendance -> !attendance.isToday())
                .forEach(attendance -> outputView.printAttendanceTime(attendance.getAttendanceDate(),
                        attendance.getState()));
        outputView.printAttendanceQueryResult(crew.calculateCountAttendance(), crew.calculateCountLate(),
                crew.calculateCountAbsence());
    }
}
