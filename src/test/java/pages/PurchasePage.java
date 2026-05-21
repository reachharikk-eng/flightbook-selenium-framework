package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage extends BasePage {

    WebDriver driver;

    public PurchasePage(WebDriver driver) {

        super(driver);

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inputName")
    WebElement nameField;

    @FindBy(id = "address")
    WebElement addressField;

    @FindBy(id = "city")
    WebElement cityField;

    @FindBy(id = "state")
    WebElement stateField;

    @FindBy(id = "zipCode")
    WebElement zipCodeField;

    @FindBy(id = "cardType")
    WebElement cardTypeDropdown;

    @FindBy(id = "creditCardNumber")
    WebElement creditCardNumberField;

    @FindBy(id = "creditCardMonth")
    WebElement cardMonthField;

    @FindBy(id = "creditCardYear")
    WebElement cardYearField;

    @FindBy(id = "nameOnCard")
    WebElement nameOnCardField;

    @FindBy(css = "input[value='Purchase Flight']")
    WebElement purchaseFlightButton;

    public void enterPassengerDetails(
            String name,
            String address,
            String city,
            String state,
            String zipCode) {

        enterText(nameField, name);

        enterText(addressField, address);

        enterText(cityField, city);

        enterText(stateField, state);

        enterText(zipCodeField, zipCode);
    }

    public void enterPaymentDetails(
            String cardType,
            String cardNumber,
            String month,
            String year,
            String nameOnCard) {

        selectDropdownByVisibleText(
                cardTypeDropdown,
                cardType);

        enterText(
                creditCardNumberField,
                cardNumber);

        enterText(
                cardMonthField,
                month);

        enterText(
                cardYearField,
                year);

        enterText(
                nameOnCardField,
                nameOnCard);
    }

    public void clickPurchaseFlight() {

        clickElement(purchaseFlightButton);
    }

    public void completePurchase(
            String name,
            String address,
            String city,
            String state,
            String zipCode,
            String cardType,
            String cardNumber,
            String month,
            String year,
            String nameOnCard) {

        enterPassengerDetails(
                name,
                address,
                city,
                state,
                zipCode);

        enterPaymentDetails(
                cardType,
                cardNumber,
                month,
                year,
                nameOnCard);

        clickPurchaseFlight();
    }
}
