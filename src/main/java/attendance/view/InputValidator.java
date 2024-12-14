package attendance.view;

import attendance.enums.ErrorMessage;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String CHOICE_FUNCTION_REGEX = "^[1|2|3|Q]$";
    private static final Pattern CHOICE_FUNCTION_FORMAT = Pattern.compile(CHOICE_FUNCTION_REGEX);

    public void validateChoiceFunctionFormat(final String choiceFunction) {
        if (!CHOICE_FUNCTION_FORMAT.matcher(choiceFunction).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_FORMAT_INVALID.getMessage());
        }
    }
}
