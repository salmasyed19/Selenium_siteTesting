package magento.p1.Tests;

import magento.p1.pages.AddProductToCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class SearchForAProductTest {
    private WebDriver driver;
    private AddProductToCart addProductToCart;

    @BeforeMethod
    public void setUp() {
       
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
        addProductToCart = new AddProductToCart(driver);
    }

    @Test
    public void testSearchForAProduct() {
        String productName = "Selene Yoga Hoodie";
        addProductToCart.searchProduct(productName);

        // Verify that the search results contain the expected product
        boolean isProductFound = driver.findElements(By.xpath("//a[@class='product-item-link' and contains(text(), '" + productName + "')]")).size() > 0;
        Assert.assertTrue(isProductFound, "Product not found in search results");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
