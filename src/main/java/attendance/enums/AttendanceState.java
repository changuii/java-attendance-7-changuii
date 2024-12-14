package attendance.enums;

public enum AttendanceState {
    ATTENDANCE("(출석)"),
    LATE("(지각)"),
    ABSENCE("(결석)");

    private String state;

    AttendanceState(final String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
