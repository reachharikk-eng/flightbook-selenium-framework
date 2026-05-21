package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FlightListPage extends BasePage {

    WebDriver driver;

    public FlightListPage(WebDriver driver) {

        super(driver);

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "table.table tbody tr")
    List<WebElement> flightRows;

    @FindBy(tagName = "h3")
    WebElement flightsHeader;

    @FindBy(css = "input[value='Choose This Flight']")
    List<WebElement> chooseFlightButtons;

    public int getFlightCount() {

        return flightRows.size();
    }

    public boolean isFlightListDisplayed() {

        return flightsHeader.isDisplayed();
    }

    public void chooseFirstFlight() {

        chooseFlightButtons.get(0).click();
    }

    public boolean verifyFlightDetailsPresent() {

        for (WebElement row : flightRows) {

            String rowText = row.getText();

            if (rowText.isEmpty()) {

                return false;
            }
        }

        return true;
    }
}
