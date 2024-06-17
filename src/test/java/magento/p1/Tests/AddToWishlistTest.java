package magento.p1.Tests;

import magento.p1.pages.AddToWishlistPage;
import magento.p1.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToWishlistTest {
    private WebDriver driver;
    private SignInPage signInPage;
    private AddToWishlistPage addToWishlistPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        signInPage = new SignInPage(driver);
        addToWishlistPage = new AddToWishlistPage(driver);
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
    }

    @Test
    public void testAddToWishlist() {
        // Sign in
        signInPage.signIn("sarah.anderson11@example.com", "1#2Dsvbs");

        // Add product to wishlist
        addToWishlistPage.searchProduct("Selene Yoga Hoodie");
        addToWishlistPage.selectProduct();
        addToWishlistPage.addToWishlist();
        addToWishlistPage.goToWishlist();

        // Assert that the product is added to the wishlist
        // You can use Selenium's assertions or TestNG assertions here
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
