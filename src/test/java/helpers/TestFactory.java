package helpers;

import models.DataModel;
import org.testng.annotations.Factory;
import testData.TestData;
import tests.TestClass1;

import static org.mozilla.javascript.TopLevel.Builtins.Object;

public class TestFactory {
    @Factory(dataProvider = "data1", dataProviderClass = DataProvider.class)
    public Object[] testFactory(DataModel dataModel) {
        return new Object[] {new TestClass1(dataModel)};
    }

}
