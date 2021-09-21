package tests;

import org.testng.ITestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CubaPetClinicMain;
import pages.CubaPetClinicLanding;


public class GoogleSearchTest extends TestBase{



    private final Logger logger = LoggerFactory.getLogger(GoogleSearchTest.class);








    @BeforeTest
    public void beforeTest(ITestContext context) {
        context.setAttribute("Attribute1", "This is the saved context attribute");
        logger.info("Things to do before the test");
    }

    @Test(enabled = true)
    public void googleSearchTest(ITestContext context) {
        pageObject1.performSearch("https://www.google.com", "Selenide");
        logger.info("Google search test completed");
    }
}

