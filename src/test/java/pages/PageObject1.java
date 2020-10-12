package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.*;


public class PageObject1 {

    public PageObject1() {

    }
    private final Logger logger = LoggerFactory.getLogger(PageObject1.class);

    private final SelenideElement googleSearch = $(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));

    @Step("Performing a google search")
    public void performSearch(String webUrl){
        open(webUrl);
        googleSearch.setValue("Searching").pressEnter();
        sleep(3000);
    }

}
