package attendance.view;

import attendance.enums.ErrorMessage;

public class InputParser {
    public int parseInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_FORMAT_INVALID.getMessage());
        }
    }
}
