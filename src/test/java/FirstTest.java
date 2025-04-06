import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FirstTest {
    @BeforeEach
    public void before() {
        System.out.println("Akcja przed każdym testem");
    }

    @Test
    public void test1() {
        Assertions.assertEquals(5, 5);
    }

    @Test
    public void test2() {
        Assertions.assertTrue(true);
    }


    @AfterEach
    public void tearDown() {
        System.out.println("Akcja po każdym tescie");
    }


    //hooks - inna nazwa na tego typu dekoratory w testach
}
