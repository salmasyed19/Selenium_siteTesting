package magento.p1.Tests;

import magento.p1.pages.SignInPage;
import magento.p1.Tests.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest {
    private WebDriver driver;
    private SignInPage signInPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dFN1Y2Nlc3Mv/");
        signInPage = new SignInPage(driver);
    }

    @Test(dataProvider = "signInData", dataProviderClass = TestData.class)
    public void testSignIn(String email, String password, boolean isSuccessExpected) {
        signInPage.signIn(email, password);

        // Add assertions or further test steps here

        if (isSuccessExpected) {
            System.out.println("Sign in successful for email: " + email);
        } else {
            System.out.println("Sign in unsuccessful for email: " + email);
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
