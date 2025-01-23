import io.github.dmk0001.passgen.utils.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilsTest {

    @Test
    void shouldReturnRandomNumberWithinRange(){
        int result = Utils.randomInt(5);
        assertTrue(result >= 0 && result < 5);

        int largeRangeResult = Utils.randomInt(5000000);
        assertTrue(largeRangeResult >= 0 && largeRangeResult < 5000000);
    }
}