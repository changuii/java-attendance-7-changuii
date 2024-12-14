package attendance.view;

import attendance.enums.DayOfWeeks;
import attendance.enums.OutputMessage;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class OutputView {
    public void printTodayAndFunctionIntroduce() {
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        print(OutputMessage.TODAY_AND_FUNCTION_INTRODUCE, month, day, DayOfWeeks.parseDayOfWeek(dayOfWeek));
    }

    public void printFunctionChoiceIntroduce() {
        print(OutputMessage.FUNCTION_CHOICE_INTRODUCE);
    }

    public void printInputCrewNameIntroduce() {
        print(OutputMessage.INPUT_CREW_NAME_INTRODUCE);
    }

    public void printInputGoToSchoolTimeIntroduce() {
        print(OutputMessage.INPUT_GO_TO_SCHOOL_TIME_INTRODUCE);
    }

    public void printInputCrewNameUpdateTimeIntroduce() {
        print(OutputMessage.INPUT_CREW_NAME_UPDATE_TIME_INTRODUCE);
    }

    public void printInputUpdateDayIntroduce() {
        print(OutputMessage.INPUT_UPDATE_DAY_INTRODUCE);
    }

    public void printInputUpdateTimeIntroduce() {
        print(OutputMessage.INPUT_UPDATE_TIME_INTRODUCE);
    }

    private void print(final Object message, final Object... values) {
        System.out.println(formatMessage(message.toString(), values));
    }

    private String formatMessage(final Object formatMessage, final Object... values) {
        return String.format(formatMessage.toString(), values);
    }
}
