package tests;
import dataproviders.FlightDataProvider;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConfirmationPage;
import pages.FlightListPage;
import pages.HomePage;
import pages.PurchasePage;

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

    @Test(priority = 3)
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

    @Test(priority = 4)
    public void verifyCompleteFlightBooking() {

        HomePage homePage =
                new HomePage(driver);

        homePage.searchFlight(
                "Boston",
                "London");

        FlightListPage flightListPage =
                new FlightListPage(driver);

        flightListPage.chooseFirstFlight();

        PurchasePage purchasePage =
                new PurchasePage(driver);

        purchasePage.completePurchase(
                "Hari",
                "123 Main Street",
                "Chennai",
                "Tamil Nadu",
                "600001",
                "Visa",
                "4111111111111111",
                "11",
                "2028",
                "Hari Karthik");

        ConfirmationPage confirmationPage =
                new ConfirmationPage(driver);

        Assert.assertTrue(
                confirmationPage
                        .isThankYouMessageDisplayed(),
                "Thank you message not displayed");

        Assert.assertTrue(
                confirmationPage
                        .getThankYouMessage()
                        .contains("Thank you"),
                "Purchase failed");

        Assert.assertFalse(
                confirmationPage
                        .getBookingId()
                        .isEmpty(),
                "Booking ID missing");
    }

    @Test(priority = 5)
    public void verifyEmptyNameValidation() {

        HomePage homePage =
                new HomePage(driver);

        homePage.searchFlight(
                "Boston",
                "London");

        FlightListPage flightListPage =
                new FlightListPage(driver);

        flightListPage.chooseFirstFlight();

        PurchasePage purchasePage =
                new PurchasePage(driver);

        purchasePage.enterPassengerDetails(
                "",
                "Chennai Street",
                "Chennai",
                "Tamil Nadu",
                "600001");

        purchasePage.enterPaymentDetails(
                "Visa",
                "4111111111111111",
                "11",
                "2028",
                "Hari");

        Assert.assertTrue(
                purchasePage.isNameFieldEmpty(),
                "Name field is not empty");
    }

    @Test(priority = 6)
    public void verifyInvalidCardNumber() {

        HomePage homePage =
                new HomePage(driver);

        homePage.searchFlight(
                "Paris",
                "Berlin");

        FlightListPage flightListPage =
                new FlightListPage(driver);

        flightListPage.chooseFirstFlight();

        PurchasePage purchasePage =
                new PurchasePage(driver);

        purchasePage.completePurchase(
                "Hari",
                "Main Street",
                "Chennai",
                "Tamil Nadu",
                "600001",
                "Visa",
                "INVALID123",
                "11",
                "2028",
                "Hari");

        String currentUrl =
                driver.getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains("confirmation"),
                "Purchase confirmation page not loaded");
    }
    @Test( priority = 7, dataProvider = "flightSearchData",
            dataProviderClass = FlightDataProvider.class)

    public void verifyMultipleRouteSearch(
            String departure,
            String destination) {

        HomePage homePage =
                new HomePage(driver);

        homePage.searchFlight(
                departure,
                destination);

        FlightListPage flightListPage =
                new FlightListPage(driver);

        Assert.assertTrue(
                flightListPage.getFlightCount() > 0,
                "No flights found");
    }
}