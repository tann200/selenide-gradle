package helpers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class PageUtilities {

    public static void clearFieldAndSetValue(SelenideElement field, String value) {
        while (!isEmpty(field.getValue())) {
            field.sendKeys(Keys.BACK_SPACE);
        }
        field.sendKeys(value, Keys.ENTER);
    }
}
