package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends BasePage {

    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {

        super(driver);

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    WebElement thankYouMessage;

    @FindBy(xpath = "//td[text()='Id']/following-sibling::td")
    WebElement bookingId;

    public boolean isThankYouMessageDisplayed() {

        return thankYouMessage.isDisplayed();
    }

    public String getThankYouMessage() {

        return getElementText(thankYouMessage);
    }

    public String getBookingId() {

        return getElementText(bookingId);
    }
}
