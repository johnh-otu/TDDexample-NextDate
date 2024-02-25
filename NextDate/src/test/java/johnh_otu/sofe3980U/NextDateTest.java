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

    @Test @Tag("valid_inputs")
    public void test1() {
        int[] out = NextDate.NextDate(19, 2, 2023);
        assertAll("test1",
                () -> assertEquals(20, out[0]),
                () -> assertEquals(2, out[1]),
                () -> assertEquals(2023, out[2])
        );
    }
    @Test @Tag("valid_inputs")
    public void test2() {
        int[] out = NextDate.NextDate(19, 6, 2024);
        assertAll("test2",
                () -> assertEquals(20, out[0]),
                () -> assertEquals(6, out[1]),
                () -> assertEquals(2024, out[2])
        );
    }
    @Test @Tag("valid_inputs")
    public void test3() {
        int[] out = NextDate.NextDate(19, 10, 2023);
        assertAll("test3",
                () -> assertEquals(20, out[0]),
                () -> assertEquals(10, out[1]),
                () -> assertEquals(2023, out[2])
        );
    }
    @Test @Tag("valid_inputs")
    public void test4() {
        int[] out = NextDate.NextDate(19, 12, 2024);
        assertAll("test4",
                () -> assertEquals(20, out[0]),
                () -> assertEquals(12, out[1]),
                () -> assertEquals(2024, out[2])
        );
    }
    @Test @Tag("valid_inputs")
    public void test5() {
        int[] out = NextDate.NextDate(30, 6, 2023);
        assertAll("test5",
                () -> assertEquals(1, out[0]),
                () -> assertEquals(7, out[1]),
                () -> assertEquals(2023, out[2])
        );
    }
    @Test @Tag("valid_inputs")
    public void test6() {
        int[] out = NextDate.NextDate(31, 10, 2024);
        assertAll("test6",
                () -> assertEquals(1, out[0]),
                () -> assertEquals(11, out[1]),
                () -> assertEquals(2024, out[2])
        );
    }
    @Test @Tag("valid_inputs")
    public void test7() {
        int[] out = NextDate.NextDate(31, 12, 2023);
        assertAll("test7",
                () -> assertEquals(1, out[0]),
                () -> assertEquals(1, out[1]),
                () -> assertEquals(2024, out[2])
        );
    }
    @Test @Tag("valid_inputs")
    public void test8() {
        int[] out = NextDate.NextDate(29, 2, 2024);
        assertAll("test8",
                () -> assertEquals(1, out[0]),
                () -> assertEquals(3, out[1]),
                () -> assertEquals(2024, out[2])
        );
    }
}
