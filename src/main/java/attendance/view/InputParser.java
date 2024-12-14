package attendance.view;

import attendance.enums.ErrorMessage;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputParser {
    private static final String LOCAL_TIME_PATTERN = "HH:mm";
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(LOCAL_TIME_PATTERN);

    public int parseInt(final String text) {
        try {
            return Integer.parseInt(text);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_FORMAT_INVALID.getMessage());
        }
    }

    public LocalTime parseLocalTime(final String timeText) {
        try {
            return LocalTime.parse(timeText, TIME_FORMATTER);
        } catch (final DateTimeParseException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_FORMAT_INVALID.getMessage());
        }
    }
}
