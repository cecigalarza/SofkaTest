package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected WebDriver driver;
    protected String baseUrl = "https://www.demoblaze.com/";

    @BeforeEach
    public void setup() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Navigate to the base URL
        driver.get(baseUrl);
    }

    @AfterEach
    public void teardown() {
        // Quit the WebDriver after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
