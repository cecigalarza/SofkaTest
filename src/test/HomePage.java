// HomePage.java
package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnProduct(String productName) {
        WebElement product = driver.findElement(By.linkText(productName));
        product.click();
    }
}