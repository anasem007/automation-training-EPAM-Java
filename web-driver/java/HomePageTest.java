import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;
    private final LocalDate pickUpDate = LocalDate.now();

    @BeforeClass
    public void setUpChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void attemptBooking() {
        page.inputPickUpLocation("Minsk, Belarus")
            .selectPickUpDate(pickUpDate)
            .selectDropOffDate(pickUpDate.plusDays(3))
            .selectSearch();
        Assert.assertFalse(page.ErrorMessageExpected());
    }

    @Test
    public void bookingDropOffTimeGreaterThanPickUpTime() {
        page.inputPickUpLocation("Minsk, Belarus")
            .selectPickUpDate(pickUpDate)
            .selectDropOffDate(pickUpDate)
            .selectPickUpTime("13","00")
            .selectDropOffTime("11","00")
            .selectSearch()
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
