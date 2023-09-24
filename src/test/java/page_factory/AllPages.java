package page_factory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AllPages {


    @FindBy(id = "react-select-categoryId-input")
    WebElement inpCategory;

    @FindBy(id = "react-select-groupId-input")
    WebElement inpGroup;

    @FindBy(id = "priceFrom")
    WebElement inpPriceFrom;

    @FindBy(id = "react-select-currency-input")
    WebElement inpCurrency;

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
    private WebElement btnAddToAddressBook;

    @FindBy(xpath = "//h1[contains(text(), 'Ulogujte se')]")
    private List<WebElement> listH1Login;

    private WebElement loginElement;

    public WebDriver driver;
    private JavascriptExecutor jsExecutor;
    private final WebDriverWait wait;

    public AllPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        jsExecutor = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

}
