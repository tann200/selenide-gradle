package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;


public class GoogleSearchPage {

    public GoogleSearchPage() {

    }
    private final Logger logger = LoggerFactory.getLogger(GoogleSearchPage.class);

    private final SelenideElement googleSearch = $(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
    private final SelenideElement googleAgreementButton = $(byClassName("jyfHyd"));
    private final SelenideElement googleConsent1 = $(byClassName("VfPpkd-RLmnJb"));

    @Step("Performing a google search")
    public void performSearch(String webUrl, String searchParameter){
        open(webUrl);
        googleAgreementButton.should(Condition.exist).scrollTo();
        googleAgreementButton.click();
        //googleConsent1.should(Condition.exist).click();
        sleep(60000);
        googleSearch.setValue(searchParameter).pressEnter();
        sleep(3000);
    }

}
