import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple")
public class NegativeTest {
    @Test
    void someTest1(){assertTrue(false);}
    @Test
    void someTest2(){assertTrue(false);}
    @Test
    void someTest3(){assertTrue(false);}
    @Test
    void someTest4(){assertTrue(false);}
}