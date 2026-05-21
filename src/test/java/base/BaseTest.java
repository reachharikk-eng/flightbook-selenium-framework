package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    ConfigReader config = new ConfigReader();

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(config.getTimeout()));

        driver.get(config.getBaseUrl());
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {

            driver.quit();
        }
    }
}
