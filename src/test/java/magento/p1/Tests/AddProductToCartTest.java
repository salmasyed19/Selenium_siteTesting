package magento.p1.Tests;

import magento.p1.pages.AddProductToCart;
import magento.p1.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class AddProductToCartTest {
    private WebDriver driver;
    private AddProductToCart addProductToCart;
    private SignInPage signInPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
        addProductToCart = new AddProductToCart(driver);
        signInPage = new SignInPage(driver);
    }

    @Test(dataProvider = "productData", dataProviderClass = TestData.class)
    public void testAddProductToCart(String email, String password, String productName, String size, String color) {
        // Sign in
        signInPage.signIn(email, password);

        // Add product to cart
        addProductToCart.searchProduct(productName);
        addProductToCart.selectProduct();
        addProductToCart.selectSize(size);
        addProductToCart.selectColor(color);
        addProductToCart.AddToCart();

        // Add assertions here to verify the product was added to the cart
        Assert.assertTrue(driver.findElement(By.cssSelector("#maincontent > div.page.messages")).isDisplayed(), "you added " + productName + " to your shopping cart");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
