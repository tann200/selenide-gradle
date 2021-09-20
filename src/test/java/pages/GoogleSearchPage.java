package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class GoogleSearchPage {

    public GoogleSearchPage() {

    }
    private final Logger logger = LoggerFactory.getLogger(GoogleSearchPage.class);

    private final SelenideElement googleSearch = $(byClassName("gLFyf"));
    private final SelenideElement googleAgreementButton = $(byClassName("jyfHyd"));
    private final SelenideElement googleConsent1 = $(byXpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div[2]/div[3]/div[2]/div/div[2]/div[1]/div/button/div[2]"));
    private final SelenideElement googleConsent2 = $(byXpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div[2]/div[4]/div[2]/div/div[2]/div[1]/div/button/span"));
    private final SelenideElement googleConsent3 = $(byXpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div[2]/div[5]/div[2]/div[2]/div/div[2]/div[1]/div/button/span"));
    private final SelenideElement acceptConsents = $(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div[2]/form/div/button/span"));

    @Step("Performing a google search")
    public void performSearch(String webUrl, String searchParameter){
        open(webUrl);
        googleAgreementButton.should(Condition.exist).scrollTo();
        googleAgreementButton.click();
        acceptConsents();
        googleSearch.setValue(searchParameter).pressEnter();
        sleep(2000);
        SelenideElement result = $(byPartialLinkText("selenide.org"));
        result.click();

    }

    private void acceptConsents() {
        googleConsent1.should(Condition.exist).parent().click();
        googleConsent2.click();
        googleConsent3.scrollTo().click();
        acceptConsents.click();

    }

}
