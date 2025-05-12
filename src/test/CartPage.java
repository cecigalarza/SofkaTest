// CartPage.java
package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToCartPage() {
        driver.findElement(By.linkText("Cart")).click();
    }

    public String getProductNameInCart(int rowNumber) {
        WebElement productNameElement = driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[2]"));
        return productNameElement.getText();
    }

    public void deleteProductFromCart(int rowNumber) {
        WebElement deleteButton = driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[4]/a"));
        deleteButton.click();
    }
}