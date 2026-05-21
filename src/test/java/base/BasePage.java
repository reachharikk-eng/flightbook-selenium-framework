package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;

    WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver,
                Duration.ofSeconds(10));
    }

    public void clickElement(WebElement element) {

        waitForVisibility(element);

        element.click();
    }

    public void enterText(WebElement element,
                          String text) {

        waitForVisibility(element);

        element.clear();

        element.sendKeys(text);
    }

    public String getElementText(WebElement element) {

        waitForVisibility(element);

        return element.getText();
    }

    public void selectDropdownByVisibleText(
            WebElement element,
            String value) {

        Select select = new Select(element);

        select.selectByVisibleText(value);
    }

    public void waitForVisibility(
            WebElement element) {

        wait.until(
                ExpectedConditions.visibilityOf(element));
    }
}
