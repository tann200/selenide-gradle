package helpers;

import testData.TestData;

public class DataProvider {

    @org.testng.annotations.DataProvider
    public Object[][] dataProvider1() {
        return new Object[][]{
                new Object[]{TestData.data1()}
        };
    }
}
