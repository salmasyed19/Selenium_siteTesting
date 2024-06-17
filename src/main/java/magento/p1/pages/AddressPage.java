package magento.p1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {
    private WebDriver driver;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addAddress(String firstName, String lastName, String company, String phoneNo, String streetAddress, String city, String stateProvince, String zipCode, String country) {
        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.id("company")).sendKeys(company);
        driver.findElement(By.id("telephone")).sendKeys(phoneNo);
        driver.findElement(By.id("street_1")).sendKeys(streetAddress);
        driver.findElement(By.id("city")).sendKeys(city);
        
        // Select state from dropdown
        Select stateDropdown = new Select(driver.findElement(By.id("region_id")));
        stateDropdown.selectByVisibleText(stateProvince);

        driver.findElement(By.id("zip")).sendKeys(zipCode);

        // Select country from dropdown
        Select countryDropdown = new Select(driver.findElement(By.id("country")));
        countryDropdown.selectByVisibleText(country);

        // Click on Save Address button
        driver.findElement(By.cssSelector("button[title='Save Address']")).click();
        
    }
    
    public void signOut() {
    	driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span")).click();
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")).click();
    }
}
