import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class HomePageTest {
    private WebDriver driver;
    private HomePage page;
    private final LocalDate pickUpDate = LocalDate.now();

    @BeforeClass
    public void setUpChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        page = new HomePage(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void attemptBooking() {
        page.inputPickUpLocation("Minsk, Belarus");
        page.selectPickUpDate(pickUpDate);
        page.selectDropOffDate(pickUpDate.plusDays(3));
        page.selectSearch();
        Assert.assertFalse(page.ErrorMessageExpected());
    }

    @Test
    public void bookingDropOffTimeGreaterThanPickUpTime() {
        page.inputPickUpLocation("Minsk, Belarus");
        page.selectPickUpDate(pickUpDate);
        page.selectDropOffDate(pickUpDate);
        page.selectPickUpTime("13","00");
        page.selectDropOffTime("11","00");
        page.selectSearch();
        Assert.assertTrue(page.ErrorMessageExpected());
    }

    @AfterClass
    public void tearDownChromeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
