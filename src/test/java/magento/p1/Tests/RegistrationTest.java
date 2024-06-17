package magento.p1.Tests;

import magento.p1.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        registrationPage = new RegistrationPage(driver);
    }

    @Test(dataProvider = "registrationData", dataProviderClass = TestData.class)
    public void testRegistration(String firstName, String lastName, String email, String password, String confirmPassword, boolean shouldSucceed) {
        registrationPage.register(firstName, lastName, email, password, confirmPassword);
        boolean registrationResult;
        
        if (shouldSucceed) {
            registrationResult = registrationPage.isRegistrationSuccessful();
        } else {
            registrationResult = registrationPage.isRegistrationFailed();
        }

        Assert.assertEquals(registrationResult, shouldSucceed, "Registration should " + (shouldSucceed ? "succeed" : "fail") + " for input: " + firstName + ", " + lastName + ", " + email + ", " + password + ", " + confirmPassword);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
