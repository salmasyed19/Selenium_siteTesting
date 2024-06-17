package magento.p1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By emailField = By.id("email_address");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("password-confirmation");
    private By createAccountButton = By.cssSelector("button[title='Create an Account']");
    private By successMessage = By.cssSelector(".message-success"); // Update with actual success message selector
    private By errorMessage = By.cssSelector(".message-error"); // Update with actual error message selector

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void fillRegistrationForm(String firstName, String lastName, String email, String password, String confirmPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField)).sendKeys(confirmPassword);
    }

    public void clickCreateAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton)).click();
    }

    public boolean isRegistrationSuccessful() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isRegistrationFailed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void register(String firstName, String lastName, String email, String password, String confirmPassword) {
        fillRegistrationForm(firstName, lastName, email, password, confirmPassword);
        clickCreateAccountButton();
        System.out.println("Attempting to register with first name: " + firstName + ", last name: " + lastName + ", email: " + email + ", password: " + password + ", and confirm password: " + confirmPassword);
    }
}
