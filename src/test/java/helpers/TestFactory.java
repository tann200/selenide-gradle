package helpers;

import models.DataModel;
import org.testng.annotations.Factory;
import testData.TestData;
import tests.TestClass1;

public class TestFactory {
    @Factory(dataProvider = "data1", dataProviderClass = DataProvider.class)
    public Object[] testFactory(DataModel dataModel) {
        return new Object[] {new TestClass1(dataModel)};
    }

}
