package blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * HomePage find the available flights flights from the departure to destination.
 */
public class HomePage {
    private final WebDriver driver;
    private WebDriverWait wait;

    private final By departureCityDropdown = By.name("fromPort");
    private final By destinationCityDropdown = By.name("toPort");
    private final By findFlightsButton = By.cssSelector("input[type='submit']");

    public  HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void selectDepartureCity(String city)
    {
        try {
        Select select = new Select(driver.findElement(departureCityDropdown));
        select.selectByVisibleText(city);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Invalid Departure city: " + city);
        }
    }

    public void selectDestinationCity(String city) {
        try {
        Select select = new Select(driver.findElement(destinationCityDropdown));
        select.selectByVisibleText(city); }
        catch (Exception e) {
            throw new IllegalArgumentException("Invalid Destination city: " + city);
        }
    }

    public void findFlights() {
        driver.findElement(findFlightsButton).click();
    }
}

