package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class URLOpener {

    protected WebDriver driver;
    protected String baseUrl = "https://www.demoblaze.com/";

    @Before
    public void setup() {
        // Configura el WebDriver usando WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl); // Abre la URL base

        // Maximiza la ventana del navegador
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        // Cierra el navegador después de cada prueba
        if (driver != null) {
            driver.quit();
        }
    }

    public void waitLoadedPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return jQuery.active == 0"));
    }
}
