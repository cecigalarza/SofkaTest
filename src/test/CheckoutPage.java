package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillCheckoutForm(String name, String country, String city, String card, String month, String year) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        nameField.sendKeys(name);

        WebElement countryField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("country")));
        countryField.sendKeys(country);

        WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city")));
        cityField.sendKeys(city);

        WebElement cardField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("card")));
        cardField.sendKeys(card);

        WebElement monthField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("month")));
        monthField.sendKeys(month);

        WebElement yearField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("year")));
        yearField.sendKeys(year);
    }

    public void clickPurchase() {
        WebElement purchaseButton = driver.findElement(By.xpath("//button[text()='Purchase']"));
        purchaseButton.click();
    }
}
