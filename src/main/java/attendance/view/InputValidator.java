package attendance.view;

import attendance.enums.ErrorMessage;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String CHOICE_FUNCTION_REGEX = "^[1|2|3|4|Q]$";
    private static final Pattern CHOICE_FUNCTION_FORMAT = Pattern.compile(CHOICE_FUNCTION_REGEX);
    private static final String DAY_REGEX = "^[0-9]{1,2}$";
    private static final Pattern DAY_FORMAT = Pattern.compile(DAY_REGEX);
    private static final int DAY_MIN = 1;
    private static final int DAY_MAX = 31;
    private static final String TIME_REGEX = "^[0-9]{2}:[0-9]{2}$";
    private static final Pattern TIME_FORMAT = Pattern.compile(TIME_REGEX);

    public void validateChoiceFunctionFormat(final String choiceFunction) {
        if (!CHOICE_FUNCTION_FORMAT.matcher(choiceFunction).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_FORMAT_INVALID.getMessage());
        }
    }

    public void validateTime(final String time) {
        if (!TIME_FORMAT.matcher(time).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_FORMAT_INVALID.getMessage());
        }
    }

    public void validateDay(final String day) {
        if (!DAY_FORMAT.matcher(day).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_FORMAT_INVALID.getMessage());
        }
    }

    public void validateDay(final int day) {
        validateDayRange(day);
    }

    private void validateDayRange(final int day) {
        if (day < DAY_MIN || DAY_MAX < day) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_FORMAT_INVALID.getMessage());
        }
    }
}
