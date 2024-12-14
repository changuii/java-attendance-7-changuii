package attendance.handler;

import java.util.function.BooleanSupplier;

public class RetryHandler {

    public void retryUntilTrue(final BooleanSupplier logic) {
        while (!logic.getAsBoolean()) {
        }
    }
}
