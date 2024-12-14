package attendance.handler;

import java.util.function.Function;

public class RetryHandler {

    public <T> void retryUntilTrue(final Function<T, Boolean> logic, final T data) {
        while (!logic.apply(data)) {
        }
    }
}
