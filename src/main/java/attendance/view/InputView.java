package attendance.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final InputValidator inputValidator;
    private final InputParser inputParser;

    public InputView(final InputValidator inputValidator, final InputParser inputParser) {
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
    }

    public String inputChoiceFunction() {
        String input = Console.readLine();
        inputValidator.validateChoiceFunctionFormat(input);
        return input;
    }

    public String inputCrewName() {
        String input = Console.readLine();
        return input;
    }

    public int inputDay() {
        String input = Console.readLine();
        inputValidator.validateDay(input);
        int day = inputParser.parseInt(input);
        inputValidator.validateDay(day);
        return day;
    }
}
