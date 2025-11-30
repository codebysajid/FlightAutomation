package blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

/**
 * ReservePage handles flight selection after cities are chosen.
 */
public class ReservePage {
    private final WebDriver driver;
    private final By flightRows = By.cssSelector("table tbody tr");
    private WebDriverWait wait;

    public ReservePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void chooseFlight(int flightSeq) {
        List<WebElement> flights = driver.findElements(flightRows);
        int totalFlights = flights.size();

        if (totalFlights == 0) {
            throw new IllegalStateException("No flights available to choose.");
        }

        if (flightSeq <= 0 || flightSeq > totalFlights) {
            flightSeq = new Random().nextInt(totalFlights) + 1;
        }

        WebElement selectedRow = flights.get(flightSeq - 1);
        selectedRow.findElement(By.cssSelector("input[type='submit']")).click();
    }
}