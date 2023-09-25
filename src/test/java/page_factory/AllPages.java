package page_factory;

import data.AppConfigData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class AllPages {


    @FindBy(id = "react-select-categoryId-input")
    WebElement inputCategory;

    @FindBy(id = "react-select-groupId-input")
    WebElement inputGroup;

    @FindBy(id = "priceFrom")
    WebElement inputPriceFrom;

    @FindBy(id = "hasPriceyes")
    WebElement checkboxHasPriceyes;

    @FindBy(id = "react-select-condition-input")
    WebElement selectCondition;

    @FindBy(xpath = "//button[span[contains(text(), 'Primeni filtere')]]")
    WebElement buttonApplyFilters;

    @FindBy(xpath = "//div[a[contains(text(), 'Početna')]]")
    WebElement divSearchResults;

    @FindBy(xpath = "//a[contains(@class, 'Pagination')]")
    List<WebElement> paginationList;

    @FindBy(xpath = "//a[contains(@class, 'CategoryBox_listItemName__Fal4k')]")
    List<WebElement> adsList;

    @FindBy(xpath = "//button[span[text()='Dodajte u adresar']]")
    WebElement buttonAddToAddressBook;


    private WebElement loginElement;
    public final WebDriver driver;
    private final JavascriptExecutor jsExecutor;
    private final WebDriverWait wait;
    private final AppConfigData appConfigData;

    public AllPages(WebDriver driver) {
        this.driver = driver;
        this.appConfigData = new AppConfigData();
        PageFactory.initElements(driver, this);
        jsExecutor = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goHomePage() {
        driver.get(appConfigData.getHomeAddress());
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
        if (!checkboxHasPriceyes.isSelected()) {
            jsExecutor.executeScript("arguments[0].click();", checkboxHasPriceyes);
        }
    }

    public void conditionSelectOptions(String options) {
        selectCondition.sendKeys(options);
        selectCondition.sendKeys(Keys.RETURN);
    }

    public void clickApplyFilters() {
        buttonApplyFilters.click();
    }

    public void verifyNumberSearchFound(Integer expectedResult) {
        wait.until(ExpectedConditions.elementToBeClickable(paginationList.get(1)));
        WebElement countWebElement = divSearchResults.findElement(By.xpath(".//span"));
        wait.until(ExpectedConditions.elementToBeClickable(paginationList.get(0)));
        String foundAdsCountString = countWebElement.getText();
        foundAdsCountString = foundAdsCountString.substring(0, foundAdsCountString.indexOf(' '));
        foundAdsCountString = foundAdsCountString.replaceAll("\\.", "");
        Integer foundAdsCount = Integer.parseInt(foundAdsCountString);
        Assertions.assertTrue(expectedResult < foundAdsCount, " :: The number of ads found is lower than expected " +
                "(expected: " + expectedResult + ", actual: " + foundAdsCount + ") :: ");
    }

    public void verifyFormLoginExist() {
        try {
            this.loginElement = driver.findElement(By.cssSelector("[class*=\"LoginModal\"]"));
            Assertions.assertNotNull(this.loginElement);
        } catch (Exception e) {
            Assertions.fail(" :: The modal login was not found on the page :: ");
        }
    }

    public void clickAddToAddressBook() {
        buttonAddToAddressBook.click();
    }

    public void goRandomAdd() {
        selectRandomAdd();
        boolean found = false;
        while (!found) {
            try {
                WebElement element = driver.findElement(By.xpath("//button[span[text()='Dodajte u adresar']]"));
                found = true;
            } catch (NoSuchElementException e) {
                goHomePage();
                selectRandomAdd();
            }
        }
    }

    public void selectRandomAdd() {
        jsExecutor.executeScript("arguments[0].click();", adsList
                .get(new Random()
                        .nextInt(adsList.size())));
    }
}
