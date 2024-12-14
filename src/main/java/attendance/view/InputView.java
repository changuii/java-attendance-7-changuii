package attendance.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final InputValidator inputValidator;

    public InputView(final InputValidator inputValidator) {
        this.inputValidator = inputValidator;
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
}
