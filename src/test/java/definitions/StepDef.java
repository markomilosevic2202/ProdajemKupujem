package definitions;



import data.ChromeOptionsConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class StepDef {




    public static WebDriver driver;


    @Before
    public void before() {
        //Ovo terba da se zove chrome Optons config
        //Data treba bude deskriptivan a ne 1,2,3,4....
        ChromeOptionsConfig chromeOptionsConfig = new ChromeOptionsConfig();

        System.setProperty(chromeOptionsConfig.getDriver(), chromeOptionsConfig.getAddress());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(chromeOptionsConfig.getData3());
        chromeOptions.addArguments(chromeOptionsConfig.getData4()); // open Browser in maximized mode
        chromeOptions.addArguments(chromeOptionsConfig.getData5()); // disabling infobars
        chromeOptions.addArguments(chromeOptionsConfig.getData6()); // disabling extensions
        chromeOptions.addArguments(chromeOptionsConfig.getData7()); // applicable to windows os only
        chromeOptions.addArguments(chromeOptionsConfig.getData8()); // overcome limited resource problems
        chromeOptions.addArguments(chromeOptionsConfig.getData9()); // Bypass OS security model
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @After(order = 0)
    public void afterClass() throws InterruptedException {
        driver.quit();
    }

    @After(order = 1)
    public void makeScreenshot(Scenario scenario) { //ime ne valja
        if (scenario.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            final byte[] src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
    }




    @Given("go to the home address")
    public void go_to_the_home_address() {

    }
    @Given("within a random ad that has an option")
    public void withinARandomAdThatHasAnOption() {
    }




    @When("in the header, click on the button Pretraži detalnjo")
    public void in_the_header_click_on_the_button_pretrazi_detalnjo() {

    }
    @When("on the model Pretraži detaljno in the input element {string} enter the parameter {string}")
    public void on_the_model_pretrazi_detaljno_in_the_input_element_enter_the_parameter(String string, String string2) {

    }
    @When("on the model Pretraži detaljno select checkbox Samo sa cenom")
    public void on_the_model_pretrazi_detaljno_select_checkbox_samo_sa_cenom() {

    }
    @When("on the model Pretraži detaljno in the select element check the option {string}")
    public void on_the_model_pretrazi_detaljno_in_the_select_element_check_the_option(String string) {

    }
    @When("on the model Pretraži detaljno click on the button Primeni filtere")
    public void on_the_model_pretrazi_detaljno_click_on_the_button_primeni_filtere() {

    }
    @When("on the Oglas page, click the button Dodaj u adresar")
    public void onTheOglasPageClickTheButtonDodajUAdresar() {
    }








    @Then("the search result is greater than {string} ads")
    public void the_search_result_is_greater_than_ads(String string) {

    }


    @Then("the login modal is displayed")
    public void theLoginModalIsDisplayed() {
    }
}


