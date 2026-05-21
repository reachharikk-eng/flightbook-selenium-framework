package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {

        super(driver);

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "fromPort")
    WebElement departureDropdown;

    @FindBy(name = "toPort")
    WebElement destinationDropdown;

    @FindBy(css = "input[type='submit']")
    WebElement findFlightsButton;

    public void selectDepartureCity(String city) {

        selectDropdownByVisibleText(
                departureDropdown,
                city);
    }

    public void selectDestinationCity(String city) {

        selectDropdownByVisibleText(
                destinationDropdown,
                city);
    }

    public void clickFindFlights() {

        clickElement(findFlightsButton);
    }

    public void searchFlight(
            String departure,
            String destination) {

        selectDepartureCity(departure);

        selectDestinationCity(destination);

        clickFindFlights();
    }
}