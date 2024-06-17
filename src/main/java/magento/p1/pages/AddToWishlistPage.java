package magento.p1.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToWishlistPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "search")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@title='Search']")
    private WebElement searchButton;

   
    
    @FindBy(css = "#maincontent > div.columns > div > div.product-info-main > div.product-social-links > div > a.action.towishlist > span")
    private WebElement addToWishlistButton;

    @FindBy(css = "#maincontent > div.columns > div.sidebar.sidebar-additional > div.block.block-wishlist > div.block-content > div > div > a")
    private WebElement wishlistLink;
    

    public AddToWishlistPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String productName) {
        searchBox.sendKeys(productName);
        searchButton.click();
    }

    public void selectProduct() {
        WebElement productLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='product-item-link' and contains(text(), 'Selene Yoga Hoodie')]")));
        productLink.click();
    }

    public void addToWishlist() {
        wait.until(ExpectedConditions.elementToBeClickable(addToWishlistButton)).click();
    }

    public void goToWishlist() {
        wait.until(ExpectedConditions.elementToBeClickable(wishlistLink)).click();
    }
}
