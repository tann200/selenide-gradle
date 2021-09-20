package tests;

import org.testng.ITestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CubaPetClinicMain;
import pages.CubaPetClinicLanding;


public class TestClass1 extends TestBase{



    private final Logger logger = LoggerFactory.getLogger(TestClass1.class);



    private CubaPetClinicLanding cubaPetClinicLanding = new CubaPetClinicLanding();
    private CubaPetClinicMain cubaPetClinicMain = new CubaPetClinicMain();




    @BeforeTest
    public void beforeTest(ITestContext context) {
        context.setAttribute("Attribute1", "This is the saved context attribute");
        logger.info("Things to do before the test");
    }




    @Test(enabled = true)
    public void Test1(ITestContext context) {
        pageObject1.performSearch("https://www.google.com", "Selenide");
        logger.info("This is TestClass1");
    }

    @Test(testName = "Add veterinarian to petClinic", enabled = false)
    public void SearchPetClinicDoctor(ITestContext context) {

        cubaPetClinicLanding.logIn("https://demo10.cuba-platform.com/petclinic", "joy", "joy");
        cubaPetClinicMain.performSearchByOptionAndParameter("Veterinarians","Last name","Oak");
    }

}

