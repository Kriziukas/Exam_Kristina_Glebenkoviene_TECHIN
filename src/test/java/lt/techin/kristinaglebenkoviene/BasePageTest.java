package lt.techin.kristinaglebenkoviene;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;

import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class BasePageTest {

    WebDriver driver;
    String mainPageURL = "http://localhost:8080/prisijungti";

    private static final Logger log = getLogger(lookup().lookupClass());

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.get(mainPageURL);
        log.info("Navigated to {}", mainPageURL);
        log.info("Test environment initialized");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
            log.info("WebDriver closed");
        }
    }
}