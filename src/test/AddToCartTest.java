package test;

import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;

public class AddToCartTest extends URLOpener {

    @Test
    public void testAddToCart() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        // Click en un producto
        waitLoadedPage();
        homePage.clickOnProduct("Samsung galaxy s6");

        // Click en "Add to cart"
        waitLoadedPage();
        driver.findElement(By.linkText("Add to cart")).click();

        // Espera a que aparezca la alerta
        Thread.sleep(1000); // Espera explícita (NO RECOMENDADA, usar WebDriverWait)
        driver.switchTo().alert().accept();

        // Vuelve a la página principal
        driver.get(baseUrl);

        // Click en otro producto
        waitLoadedPage();
        homePage.clickOnProduct("Nokia lumia 1520");

        // Click en "Add to cart"
        waitLoadedPage();
        driver.findElement(By.linkText("Add to cart")).click();

        // Espera a que aparezca la alerta
        Thread.sleep(1000); // Espera explícita (NO RECOMENDADA, usar WebDriverWait);
        driver.switchTo().alert().accept();

        // Navega a la página del carrito
        waitLoadedPage();
        cartPage.navigateToCartPage();

        // Verifica que los productos estén en el carrito
        waitLoadedPage();
        //Assert.assertEquals("Samsung galaxy s6", cartPage.getProductNameInCart(1));
       //Assert.assertEquals("Nokia lumia 1520", cartPage.getProductNameInCart(2));

        //driver.findElement(By.name("button")).click();
        //driver.findElement(By.xpath("//button[text()='Place Order']")).click();

        //driver.findElement(By.xpath("//div[@id='page-wrapper']//button[@class='btn btn-success']")).click();

        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement placeOrderButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='page-wrapper']//button[@class='btn btn-success']"))
        );
        placeOrderButton.click();*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement placeOrderButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='page-wrapper']//button[@class='btn btn-success']"))
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", placeOrderButton);

        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("elementoOculto"))
        );

        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].style.display = 'block';", element);

        // Verifica si el atributo 'disabled' está presente para eliminarlo
        if (element.getAttribute("disabled") != null) {
            js.executeScript("arguments[0].removeAttribute('disabled');", element);
        }
        //Si no, da click directo
        js.executeScript("arguments[0].click();", element);


        //waitLoadedPage();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutForm("Cecilia Galarza", "ECU", "Quito", "1234567890", "11", "2025");
        checkoutPage.clickPurchase();

        //WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        //nameField.sendKeys("Cecilia");

    }
}
