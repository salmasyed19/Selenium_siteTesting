package magento.p1.Tests;

import magento.p1.pages.AddressPage;
import magento.p1.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

import java.time.Duration;

public class AddAddressTest {
    WebDriver driver;
    SignInPage signInPage;
    AddressPage addressPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        signInPage = new SignInPage(driver);
        addressPage = new AddressPage(driver);
    }

    @Test(dataProvider = "addressData", dataProviderClass = TestData.class)
    public void testAddAddress(String email, String password, String firstName, String lastName, String company, String phoneNo, String streetAddress, String city, String stateProvince, String zipCode, String country, boolean isSuccess) throws InterruptedException {
        // Navigate to the Magento homepage
        driver.get("https://magento.softwaretestingboard.com/customer/address/new");

        // Sign in
        signInPage.signIn(email, password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement accountMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span")));
        accountMenu.click();

        // Wait for and click on the "My Account" link by URL
        WebElement myAccountLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/']")));
        myAccountLink.click();
       
        // Navigate to the Address Book
        WebElement addressBookLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/address/']")));
        addressBookLink.click();

        // Navigate to add new address
        WebElement addNewAddressButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#maincontent > div.columns > div.column.main > div.actions-toolbar > div.primary > button > span")));
        addNewAddressButton.click();

        // Add address details
        addressPage.addAddress(firstName, lastName, company, phoneNo, streetAddress, city, stateProvince, zipCode, country);

        // Verification
        if (isSuccess) {
            // Check for a success message or the presence of the new address in the address book
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#maincontent > div.page.messages > div:nth-child(2) > div > div")));
            Assert.assertTrue(successMessage.isDisplayed(), "The address was not added successfully.");
        } else {
            // Check for error messages or the absence of the new address
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#zip-error")));
            Assert.assertTrue(errorMessage.isDisplayed(), "This is a required field");
        }

        // Sign out
        addressPage.signOut();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

   
