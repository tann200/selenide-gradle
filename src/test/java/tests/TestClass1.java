package tests;

import models.DataModel;
import org.testng.ITestContext;
import pages.PageObject1;
import testData.TestData;
import helpers.DataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;




public class TestClass1 extends TestBase{



    private final Logger logger = LoggerFactory.getLogger(TestClass1.class);

    //Factory for dataproviders
    private final DataModel dataModel;
    @Factory(dataProvider = "dataProvider1", dataProviderClass = DataProvider.class)
    public TestClass1(DataModel dataModel){
        super();
        this.dataModel=dataModel;
    }



    @BeforeTest
    public void beforeTest(ITestContext context) {
        context.setAttribute("Attribute1", "This is the saved context attribute");
        logger.info("Things to do before the test");
    }




    @Test
    public void Test1(ITestContext context) {
        pageObject1.performSearch(webUrl);
        logger.info("This is TestClass1");


    }

    @Test
    public void Test2(ITestContext context) {
        logger.info("This is Test2");
        logger.info(context.getAttribute("Attribute1").toString());
    }

}

