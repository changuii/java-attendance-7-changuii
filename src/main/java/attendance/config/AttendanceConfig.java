package attendance.config;

import attendance.controller.AttendanceController;

public abstract class AttendanceConfig {
    public static AttendanceController createController(){
        return new AttendanceController();
    }
}
