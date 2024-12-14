package attendance;

import attendance.config.AttendanceConfig;
import attendance.controller.AttendanceController;

public class Application {
    public static void main(String[] args) {
        AttendanceController controller = AttendanceConfig.createController();
        controller.run();
    }
}
