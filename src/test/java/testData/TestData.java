package testData;

import models.DataModel;

public class TestData {
    
    public TestData() {
    }
        
        public static DataModel data1(){
            DataModel dataModel = new DataModel();
            dataModel.username = "1";
            dataModel.password = "2";
            return dataModel;

        }

}
