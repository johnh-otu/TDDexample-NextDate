package johnh_otu.sofe3980U;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.Iterator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class NextDateTest {

    static String daymsg = "Invalid: day must be in [1,lastDayOfMonth]";
    static String monmsg = "Invalid: month must be in [1,12]";
    static String yearmsg = "Invalid: year must be in [1812,2212]";

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test @Tag("invalid_inputs")
    public void negativeInputs() {
        assertAll("negative_inputs",
                () -> {
                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        NextDate.NextDate(-3, 2, 2023);
                    });
                    assertEquals(daymsg, e.getMessage());
                },
                () -> {
                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        NextDate.NextDate(19, -4, 2023);
                    });
                    assertEquals(monmsg, e.getMessage());
                },
                () -> {
                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        NextDate.NextDate(19, 2, -5);
                    });
                    assertEquals(yearmsg, e.getMessage());
                }
        );
    }

    @Test @Tag("invalid_inputs")
    public void zeroInputs() {
        assertAll("zero_inputs",
                () -> {
                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        NextDate.NextDate(0, 2, 2023);
                    });
                    assertEquals(daymsg, e.getMessage());
                },
                () -> {
                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        NextDate.NextDate(19, 0, 2023);
                    });
                    assertEquals(monmsg, e.getMessage());
                },
                () -> {
                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        NextDate.NextDate(19, 2, 0);
                    });
                    assertEquals(yearmsg, e.getMessage());
                }
        );
    }

    @Test @Tag("invalid_inputs")
    public void positiveInvalidInputs() {
        assertAll("pos_invalid_inputs",
                () -> {
                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        NextDate.NextDate(29, 2, 2023);
                    });
                    assertEquals(daymsg, e.getMessage());
                },
                () -> {
                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        NextDate.NextDate(19, 15, 2023);
                    });
                    assertEquals(monmsg, e.getMessage());
                },
                () -> {
                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        NextDate.NextDate(19, 2, 2213);
                    });
                    assertEquals(yearmsg, e.getMessage());
                }
        );
    }
}
