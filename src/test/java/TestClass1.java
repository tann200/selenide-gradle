import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public class TestClass1 {
    private final Logger LOGGER = LoggerFactory.getLogger(TestClass1.class);


    @Test
    public void Test1() {
        LOGGER.info("This is TestClass1");
    }

    @Test
    public void Test2() {
        LOGGER.info("This is Test2");
    }

}
