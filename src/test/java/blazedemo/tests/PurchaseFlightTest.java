package blazedemo.tests;

import blazedemo.base.BaseTest;
import blazedemo.pages.*;
import blazedemo.utils.DataGenerator;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class PurchaseFlightTest extends BaseTest {


    // Test End-to-End flight purchase with fixed parameters
    @Test
    public void test1ValidFixedInputs() {
        purchaseEndToEnd("Boston", "Berlin", 2);
    }
    @Test
    public void test2ValidFixedInputs() {
        purchaseEndToEnd("Paris", "Berlin", 0);
    }

    // Test End-to-End flight purchase with all random parameters
    @Test
    public void testAllRandomInputs() {
            purchaseEndToEnd(null, null, 0);
    }

    // User can enter as per choice
    @Test
    public void userChoice() {
        purchaseEndToEnd("Portland", "Dublin", 3);
    }

    // Test End-to-End flight purchase with fixed parameters
    @Test
    public void testInvalidSameCitySelection() {

            purchaseEndToEnd("Boston", "Boston", 1);
    }

    public void purchaseEndToEnd(String deptCity, String desCity, Integer flightSeq) {
        try {
            driver.get("https://blazedemo.com");

            //  Select cities
            HomePage home = new HomePage(driver);
            if (deptCity == null) {
                deptCity = DataGenerator.randomDepartureCity(driver);
            }
            if (desCity == null) {
                desCity = DataGenerator.randomDestinationCity(driver);
            }

            home.selectDepartureCity(deptCity);
            home.selectDestinationCity(desCity);
            home.findFlights();

            // Choose flight
            ReservePage reserve = new ReservePage(driver);
            reserve.chooseFlight(flightSeq);

            // Fill purchase form with random dummy data
            PurchasePage purchase = new PurchasePage(driver);
            String fullName = DataGenerator.randomName();
            purchase.fillForm(
                    fullName,
                    DataGenerator.randomAddress(),
                    DataGenerator.randomCity(),
                    DataGenerator.randomState(),
                    DataGenerator.randomZip(),
                    DataGenerator.randomCardType(),
                    DataGenerator.randomVisa(),
                    DataGenerator.expiryMonth(),
                    DataGenerator.expiryYear(),
                    fullName
            );
            purchase.clickPurchase();

            // Validate confirmation
            ConfirmationPage confirm = new ConfirmationPage(driver);
            Assert.assertEquals(confirm.getStatus(), "PendingCapture", "Status validation failed");
            Assert.assertTrue(confirm.getPrice() > 100.00, "Price validation failed");
        } catch (Exception e) {
            String msg = e.getMessage();
            // If the exception is the expected one, mark test as pass
            if (msg.contains("Invalid Destination city")) {
                System.out.println("Negative test passed: caught expected exception: " + msg);
            } else {
                Assert.fail("Test failed due to exception: " + msg);
            }
        }

    }
}