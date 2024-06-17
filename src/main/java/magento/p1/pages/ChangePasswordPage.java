package magento.p1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage {
    WebDriver driver;

    // Locators
    By currentPasswordLocator = By.cssSelector("#current-password");
    By newPasswordLocator = By.cssSelector("#password");
    By confirmPasswordLocator = By.cssSelector("#password-confirmation");
    By saveButtonLocator = By.cssSelector("#form-validate > div > div.primary > button > span");
    By successMessageLocator = By.cssSelector(".message-success.success.message");
    By errorMessageLocator = By.cssSelector(".message-error.error.message");

    // Constructor
    public ChangePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with the page
    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        driver.findElement(currentPasswordLocator).sendKeys(currentPassword);
        driver.findElement(newPasswordLocator).sendKeys(newPassword);
        driver.findElement(confirmPasswordLocator).sendKeys(confirmPassword);
        driver.findElement(saveButtonLocator).click();
    }

    // Method to verify if success message is displayed
    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successMessageLocator).isDisplayed();
    }

    // Method to verify if error message is displayed
    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessageLocator).isDisplayed();
    }
}
