package blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * ConfirmationPage validates the purchase result after submitting the flight form.
 * It validates the status and price.
 */
public class ConfirmationPage {
    private final WebDriver driver;

    // Locators for confirmation details
    private final By statusField = By.xpath("//td[text()='Status']/following-sibling::td");
    private final By priceField = By.xpath("//td[text()='Amount']/following-sibling::td");
    private WebDriverWait wait;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getStatus() {
        return driver.findElement(statusField).getText().trim();
    }

    public double getPrice() {
        String priceText = driver.findElement(priceField).getText().replace("USD", "").trim();
        return Double.parseDouble(priceText);
    }
}