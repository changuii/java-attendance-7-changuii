package attendance.enums;

import java.time.DayOfWeek;
import java.util.Arrays;

public enum DayOfWeeks {
    MONDAY(DayOfWeek.MONDAY, "월요일"),
    TUESDAY(DayOfWeek.TUESDAY, "화요일"),
    WEDNESDAY(DayOfWeek.WEDNESDAY, "수요일"),
    THURSDAY(DayOfWeek.TUESDAY, "목요일"),
    FRIDAY(DayOfWeek.FRIDAY, "금요일"),
    SATURDAY(DayOfWeek.SATURDAY, "토요일"),
    SUNDAY(DayOfWeek.SUNDAY, "일요일");

    private DayOfWeek dayOfWeek;
    private String koreanDayOfWeek;

    DayOfWeeks(final DayOfWeek dayOfWeek, final String koreanDayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        this.koreanDayOfWeek = koreanDayOfWeek;
    }

    public static String parseDayOfWeek(final DayOfWeek target) {
        return Arrays.stream(values())
                .filter(dayOfWeeks -> dayOfWeeks.dayOfWeek == target)
                .map(dayOfWeeks -> dayOfWeeks.koreanDayOfWeek)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.DAY_OF_WEEKS_INVALID.getMessage()));
    }
}
