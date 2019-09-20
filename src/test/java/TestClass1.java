import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TestClass1 {
    private final Logger LOGGER = LoggerFactory.getLogger(TestClass1.class);

    private static SelenideElement googleSearch = $(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));


    @Test
    public void Test1() {

        LOGGER.info("This is TestClass1");
        open("https://www.google.com");
        googleSearch.setValue("Searching");

    }

    @Test
    public void Test2() {
        LOGGER.info("This is Test2");
    }

}
