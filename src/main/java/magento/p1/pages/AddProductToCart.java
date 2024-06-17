package magento.p1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddProductToCart {
    private WebDriver driver;
    private WebDriverWait wait;

    public AddProductToCart(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void searchProduct(String productName) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchBox.submit();
    }

    public void selectProduct() {
        WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".product-item-link")));
        productLink.click();
    }

    public void selectSize(String sizeId) {
        WebElement sizeOption = wait.until(ExpectedConditions.elementToBeClickable(By.id("option-label-size-143-item-" + sizeId)));
        sizeOption.click();
    }

    public void selectColor(String colorId) {
        WebElement colorOption = wait.until(ExpectedConditions.elementToBeClickable(By.id("option-label-color-93-item-" + colorId)));
        colorOption.click();
    }

    public void AddToCart() {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("product-addtocart-button")));
        addToCartButton.click();
    }

    public void signOut() {
        WebElement accountMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span")));
        accountMenu.click();
        WebElement signOutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")));
        signOutLink.click();
        wait.until(ExpectedConditions.urlToBe("https://magento.softwaretestingboard.com/customer/account/logout"));
    }
}
