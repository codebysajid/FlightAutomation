package blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * PurchasePage handles filling out passenger details and submitting the purchase form.
 * Dummy user data can be generated dynamically for each test run.
 */
public class PurchasePage {
    private final WebDriver driver;


    private final By nameField = By.id("inputName");
    private final By addressField = By.id("address");
    private final By cityField = By.id("city");
    private final By stateField = By.id("state");
    private final By zipField = By.id("zipCode");
    private final By cardTypeDropdown = By.name("cardType");
    private final By cardField = By.id("creditCardNumber");
    private final By monthField = By.id("creditCardMonth");
    private final By yearField = By.id("creditCardYear");
    private final By nameOnCardField = By.id("nameOnCard");
    private final By purchaseButton = By.cssSelector("input[type='submit']");

    public PurchasePage(WebDriver driver) {

        this.driver = driver;
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("inputName")));

    }

    public void selectCardType(String type) {
        WebElement dropdown = driver.findElement(cardTypeDropdown);
        Select select = new Select(dropdown);
        select.selectByVisibleText(type);
    }

    public void fillForm(String name, String address, String city, String state,
                         String zip, String cardType, String card, String month, String year, String nameOnCard) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(zipField).sendKeys(zip);
        selectCardType(cardType);
        driver.findElement(cardField).sendKeys(card);
        driver.findElement(monthField).sendKeys(month);
        driver.findElement(yearField).sendKeys(year);
        driver.findElement(nameOnCardField).sendKeys(nameOnCard);
    }

    public void clickPurchase() {
        driver.findElement(purchaseButton).click();
    }
}