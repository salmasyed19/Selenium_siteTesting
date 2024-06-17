package magento.p1.Tests;

import magento.p1.pages.ChangePasswordPage;
import magento.p1.pages.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class ChangePaswordTest {
    WebDriver driver;
    SignInPage signInPage;
    ChangePasswordPage changePasswordPage;
    

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        signInPage = new SignInPage(driver);
        changePasswordPage = new ChangePasswordPage(driver);
        
    }

    @Test(dataProvider = "changePasswordData", dataProviderClass = TestData.class)
    public void testChangePassword(String email, String password, String currentPassword, String newPassword, String confirmPassword, boolean expectSuccess) {
        // Navigate to the Magento login page
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");

        // Sign in
        signInPage.signIn(email, password);

        // Wait for account menu and click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button"))).click();

        // Wait for my account link and click
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'My Account')]"))).click();

        // Wait for change password link and click
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Change Password')]"))).click();

        // Change the password
        changePasswordPage.changePassword(currentPassword, newPassword, confirmPassword);

        // Check for success or error messages
        if (expectSuccess) {
            Assert.assertTrue(changePasswordPage.isSuccessMessageDisplayed(), "Password change should succeed for valid input");
        } else {
            Assert.assertTrue(changePasswordPage.isErrorMessageDisplayed(), "Password change should fail for invalid input");
        }

        // Sign out
      
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
 