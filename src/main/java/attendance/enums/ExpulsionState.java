package attendance.enums;

import java.util.Arrays;

public enum ExpulsionState {
    EXPULSION(5, Integer.MAX_VALUE, "(제적)"),
    INTERVIEW(3, 4, "(면담)"),
    WARNING(2, 2, "(주의)"),
    EMPTY(0, 1, "");
    private static final int LATE_TO_ABSENCE = 3;
    private int minboundary;
    private int maxBoundary;
    private String state;

    ExpulsionState(final int minboundary, final int maxBoundary, final String state) {
        this.minboundary = minboundary;
        this.maxBoundary = maxBoundary;
        this.state = state;
    }

    public static ExpulsionState matchByLateAndAbsence(final int lateCount, final int absenceCount) {
        int count = absenceCount + lateCount / LATE_TO_ABSENCE;
        return Arrays.stream(values())
                .filter(expulsionState -> expulsionState.minboundary <= count && count <= expulsionState.maxBoundary)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public String toString() {
        return state;
    }

    public String getState() {
        return state.replaceAll("[(|)]", "");
    }
}
