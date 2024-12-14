package attendance.domain;

import java.time.LocalDateTime;

public class Attendance {
    private final LocalDateTime attendanceDate;

    private Attendance(final LocalDateTime attendanceDate){
        this.attendanceDate = attendanceDate;
    }

    public static Attendance from(final LocalDateTime attendanceDate){
        return new Attendance(attendanceDate);
    }

}
