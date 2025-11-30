package blazedemo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class DataGenerator {
    private static final Random random = new Random();

    // Random name
    public static String randomName() {
        String[] names = {"John", "Jon", "Ian", "Gupta", "Patel", "Pandey"};
        return names[random.nextInt(names.length)];
    }

    // Random address/city/state/zip
    public static String randomAddress() {
        return random.nextInt(999) + " Test Street";
    }

    public static String randomCity() {
        String[] cities = {"New York", "Boston", "Chicago"};
        return cities[random.nextInt(cities.length)];
    }

    public static String randomState() {
        String[] states = {"NY", "MA", "IL"};
        return states[random.nextInt(states.length)];
    }

    public static String randomZip() {
        return String.valueOf(10000 + random.nextInt(99999));
    }

    public static String randomCardType() {
        String[] types = {"Visa", "American Express", "Diner's Club"};
        return types[random.nextInt(types.length)];
    }

    public static String randomVisa() {
        return String.valueOf(123456789 + random.nextInt(999999999));
    }

    public static String expiryMonth() {
        return String.valueOf(1 + random.nextInt(12));
    }

    public static String expiryYear() {
        return String.valueOf(2025 + random.nextInt(5));
    }

    // Random departure/destination from dropdowns
    public static String randomDepartureCity(WebDriver driver) {
        List<WebElement> options = driver.findElements(By.cssSelector("select[name='fromPort'] option"));
        return options.get(random.nextInt(options.size())).getText();
    }

    public static String randomDestinationCity(WebDriver driver) {
        List<WebElement> options = driver.findElements(By.cssSelector("select[name='toPort'] option"));
        return options.get(random.nextInt(options.size())).getText();
    }
}