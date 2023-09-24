package page_factory;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AllPages {


    @FindBy(id = "react-select-categoryId-input")
    WebElement inputCategory;

    @FindBy(id = "react-select-groupId-input")
    WebElement inputGroup;

    @FindBy(id = "priceFrom")
    WebElement inputPriceFrom;

    @FindBy(id = "react-select-currency-input")
    WebElement inputCurrency;

    @FindBy(id = "hasPriceyes")
    WebElement chbHasPriceyes;

    @FindBy(id = "react-select-condition-input")
    WebElement selCondition;

    @FindBy(xpath = "//button[span[contains(text(), 'Primeni filtere')]]")
    WebElement btnApplyFilters;

    @FindBy(xpath = "//div[a[contains(text(), 'Početna')]]")
    WebElement divSearchResults;
    @FindBy(xpath = "//a[contains(@class, 'Pagination')]")
    List<WebElement> paginationList;

    @FindBy(xpath = "//a[contains(@class, 'CategoryBox_listItemName__Fal4k')]")
    List<WebElement> adsList;

    @FindBy(xpath = "//button[span[text()='Dodajte u adresar']]")
    WebElement btnAddToAddressBook;

    @FindBy(xpath = "//h1[contains(text(), 'Ulogujte se')]")
    List<WebElement> listH1Login;

    private WebElement loginElement;

    public WebDriver driver;
    private final JavascriptExecutor jsExecutor;
    private final WebDriverWait wait;

    public AllPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        jsExecutor = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public void clickBtnSearchDetail() {
        WebElement element = (WebElement) jsExecutor.executeScript("return document.querySelector('button[aria-label=\"Pretražite detaljno \"]')");
        element.click();
    }

    public void inputAction(String inputType, String value) {
        WebElement inputWebElement;
        if (inputType.equals("CATEGORY")) {
            inputWebElement = inputCategory;
        } else if (inputType.equals("GROUP")) {
            inputWebElement = inputGroup;
        } else if (inputType.equals("PRICE_TO")) {
            inputWebElement = inputPriceFrom;
        } else {
            inputWebElement = null;
            throw new InvalidArgumentException(" :: Unknown input type :: ");
        }
        inputWebElement.sendKeys(value);
        inputWebElement.sendKeys(Keys.RETURN);

    }

    public void checkCheckboxHasPriceYes() {
        if (!chbHasPriceyes.isSelected()) {
            jsExecutor.executeScript("arguments[0].click();", chbHasPriceyes);
        }
    }

    public void conditionSelectOptions(String options) {
        selCondition.sendKeys(options);
        selCondition.sendKeys(Keys.RETURN);
    }

    public void clickApplyFilters() {
        btnApplyFilters.click();
    }

    public void verifyNumberSearchFound(Integer expectedResult) {
        wait.until(ExpectedConditions.elementToBeClickable(paginationList.get(1)));
        WebElement countWebElement = divSearchResults.findElement(By.xpath(".//span"));
      //  wait.until(w -> countWebElement.getText().equals("0"));
        String foundAdsCountString = countWebElement.getText();
        foundAdsCountString = foundAdsCountString.substring(0, foundAdsCountString.indexOf(' '));
        foundAdsCountString = foundAdsCountString.replaceAll("\\.", "");
        Integer foundAdsCount = Integer.parseInt(foundAdsCountString);
        Assertions.assertTrue(expectedResult < foundAdsCount, " :: The number of ads found is lower than expected " +
                "(expected: " + expectedResult + ", actual: " + foundAdsCount + ") :: ");
    }

}
