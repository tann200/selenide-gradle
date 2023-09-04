package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.ApplicationProperties;
import config.Environment;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.PageObject1;

public class TestBase {

    private final Logger logger = LoggerFactory.getLogger(TestBase.class);

    public Environment env = new Environment();

    public final PageObject1 pageObject1 = new PageObject1();



    @Autowired
    protected ApplicationProperties applicationProperties;

    public void before(ITestContext context) {
        String baseUrl = applicationProperties.getService().getBaseService().getUri();
    }


    @Step("{0}")
    public static void allureLog(final String message){
        //Logs message as Allure report step, intentionally empty
    }


    @BeforeSuite
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

    }


    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception{
        logger.info("Quitting driver");
        //quit();
    }


}
