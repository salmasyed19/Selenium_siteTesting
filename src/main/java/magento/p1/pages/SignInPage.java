package magento.p1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By emailField = By.id("email");
    private By passwordField = By.id("pass");
    private By signInButton = By.id("send2");
    private By accountIcon = By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.customer-welcome > span > button"); // Update with the correct CSS selector
    private By signOutLink = By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.customer-welcome.active > div > ul > li.authorization-link > a"); // Update with the correct CSS selector

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void fillSignInForm(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void clickSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public void signIn(String email, String password) {
        fillSignInForm(email, password);
        clickSignInButton();
        System.out.println("Attempting to sign in with email: " + email + " and password: " + password);
    }

    public void signOut() {
        wait.until(ExpectedConditions.elementToBeClickable(accountIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(signOutLink)).click();
        System.out.println("Signing out");
    }
}
