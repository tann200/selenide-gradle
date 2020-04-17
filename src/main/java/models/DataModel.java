package models;


import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Getter
@Setter
public class DataModel {
    public DataModel(){

    }
    private static Logger logger = LoggerFactory.getLogger(DataModel.class);

    public String username;
    public String password;
}
