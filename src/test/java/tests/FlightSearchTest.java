package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlightListPage;
import pages.HomePage;

public class FlightSearchTest extends BaseTest {

    @Test(priority = 1)
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

    @Test(priority = 2)
    public void verifyFlightResultsDisplayed() {

        HomePage homePage =
                new HomePage(driver);

        homePage.searchFlight(
                "Paris",
                "Buenos Aires");

        FlightListPage flightListPage =
                new FlightListPage(driver);

        Assert.assertTrue(
                flightListPage.isFlightListDisplayed(),
                "Flight list page not displayed");

        Assert.assertTrue(
                flightListPage.getFlightCount() > 0,
                "No flights found");

        Assert.assertTrue(
                flightListPage.verifyFlightDetailsPresent(),
                "Flight details missing");
    }

    @Test
    public void verifyFlightSelection() {

        HomePage homePage =
                new HomePage(driver);

        homePage.searchFlight(
                "Paris",
                "London");

        FlightListPage flightListPage =
                new FlightListPage(driver);

        flightListPage.chooseFirstFlight();

        String currentUrl =
                driver.getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains("purchase"),
                "Purchase page not loaded");
    }
}