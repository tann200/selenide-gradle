package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import config.Environment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class CubaPetClinicMain {

    public CubaPetClinicMain() {

    }
    private final Logger logger = LoggerFactory.getLogger(CubaPetClinicMain.class);
    private Environment env = new Environment();

    private final ElementsCollection sideMenu = $$(byClassName("c-sidemenu-item-caption"));
    private final SelenideElement title = $(byClassName("v-label-c-app-title"));
    private final SelenideElement searchButton = $(byClassName("filter-search-button"));
    private final SelenideElement addSearchCondition = $(byText("Add search condition"));
    private final SelenideElement searchTextArea = $(byClassName("v-textfield"));
    private final SelenideElement modalSelectButton = $(byClassName("v-slot-c-primary-action"));
    private final SelenideElement modalOptions = $(byClassName("c-tree-composition")).$(byText("Last Name"));
    private final SelenideElement searchParameterField = $(byClassName("v-textfield-param-field"));
    private final SelenideElement popupButton = $(byClassName("v-popupbutton"));
    private final SelenideElement popupContent = $(byClassName("v-popupbutton-popup"));
    private final SelenideElement filterButtonGroup = $(byClassName("filter-search-button-layout"));
    private final SelenideElement logoutButton = $(byClassName("c-logout-button"));

    @Step("Perform a seaarch by paraameters and log out")
    public void performSearchByOptionAndParameter(String searchOption, String filterParameter, String searchParameter){
        selectMasterDataOptions(searchOption);
        setAddSearchCondition(filterParameter);
        searchWithOption(searchOption);
        clearSearchParameters();
        logOut();
    }

    private void selectMasterDataOptions(String optionValue) {
        sideMenu.find(text("Master Data")).click();
        sideMenu.find(text(optionValue)).shouldBe(visible).click();
        searchButton.should(appear);
    }

    private void setAddSearchCondition(String condition) {
        addSearchCondition.click();
        searchTextArea.sendKeys(condition);
        searchTextArea.sendKeys(Keys.RETURN);
        modalOptions.click();
        modalSelectButton.click();
    }

    private void searchWithOption(String searchOption) {
        searchParameterField.should(exist).click();
        searchParameterField.sendKeys(searchOption);
        searchButton.click();

    }

    private void clearSearchParameters() {
        filterButtonGroup.findElement(By.className("v-popupbutton")).click();
        popupContent.should(exist).findElement(By.className("v-csslayout-c-popupbutton-container")).click();
        addSearchCondition.should(disappear);
    }

    private void logOut() {
        logoutButton.click();
    }

}
