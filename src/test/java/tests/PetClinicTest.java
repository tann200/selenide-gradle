package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CubaPetClinicLanding;
import pages.CubaPetClinicMain;


public class PetClinicTest extends TestBase{



    private final Logger logger = LoggerFactory.getLogger(PetClinicTest.class);



    private CubaPetClinicLanding cubaPetClinicLanding = new CubaPetClinicLanding();
    private CubaPetClinicMain cubaPetClinicMain = new CubaPetClinicMain();




    @BeforeTest
    public void beforeTest(ITestContext context) {
        context.setAttribute("Attribute1", "This is the saved context attribute");
        logger.info("Things to do before the test");
    }


    @Test(testName = "Add veterinarian to petClinic", enabled = true)
    public void SearchPetClinicDoctor(ITestContext context) {

        cubaPetClinicLanding.logIn("https://demo10.cuba-platform.com/petclinic", "joy", "joy");
        cubaPetClinicMain.performSearchByOptionAndParameter("Veterinarians","Last name","Oak");
    }

}

