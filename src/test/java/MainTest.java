import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.*;
class MainTest {

    @Test
    @Timeout(value = 22, unit = SECONDS)
    @Disabled
    void mainExecutionTimeTest() throws Exception {
        Main.main(new String[]{});
    }
}