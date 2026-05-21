package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class FlightSearchTest extends BaseTest {

    @Test
    public void verifyFlightSearch() {

        HomePage homePage = new HomePage(driver);

        homePage.searchFlight(
                "Boston",
                "London");

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains("reserve"),
                "Flight search failed");
    }
}