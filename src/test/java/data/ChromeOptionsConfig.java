package data;



import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChromeOptionsConfig {
    public String driver = "webdriver.chrome.driver";
    public String address = "src/main/resources/chromedriver";
    public String data3 = "--remote-allow-origins=*";
    public String data4 = "start-maximized"; // open Browser in maximized mode
    public String data5 = "disable-infobars";// disabling infobars
    public String data6 = "--disable-extensions";// disabling extensions
    public String data7 = "--disable-gpu";// applicable to windows os only
    public String data8 = "--disable-dev-shm-usage"; // overcome limited resource problems
    public String data9 = "--no-sandbox";// Bypass OS security model

}