import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class HomePage {

    private final String HOMEPAGE_URL = "https://www.rentalcars.com/en/";
    private final int WAIT_TIMEOUT_SECONDS = 30;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEE d MMM yyyy", Locale.ENGLISH);

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(HOMEPAGE_URL);
        PageFactory.initElements(this.driver, this);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    @FindBy(xpath = "//*[@id=\"ftsAutocomplete\"]")
    private WebElement pickUpLocation;

    @FindBy(xpath = "//*[@id=\"dropFtsAutocomplete\"]")
    private WebElement dropOffLocation;

    @FindBy(xpath = "//*[@id=\"pu-short-date\"]")
    private WebElement pickUpDate;

    @FindBy(xpath = "//*[@id=\"do-short-date\"]")
    private WebElement dropOffDate;

    @FindBy(xpath = "//*[@id=\"puHour\"]")
    private WebElement puHour;

    @FindBy(xpath = "//*[@id=\"puMinute\"]")
    private WebElement puMinute;

    @FindBy(xpath = "//*[@id=\"doHour\"]")
    private WebElement doHour;

    @FindBy(xpath = "//*[@id=\"doMinute\"]")
    private WebElement doMinute;

    @FindBy(xpath = "//input[@id=\"formsubmit\"]")
    private WebElement search;


    public void inputPickUpLocation(String pickLoc) {
        pickUpLocation.sendKeys(pickLoc);
    }

    public void selectPickUpDate(LocalDate picDate) {
        pickUpDate.sendKeys(picDate.format(dateFormatter));
    }

    public void selectDropOffDate(LocalDate dropDate) {
        dropOffDate.sendKeys(dropDate.format(dateFormatter));
    }

    public void selectSearch() {
        search.click();
    }


    public boolean errorMessageExpected() {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return wait.until(ExpectedConditions.alertIsPresent()) != null;
    }

    public void selectPickUpTime(String picHour, String picMinute) {
        new Select(puHour).selectByValue(picHour);
        new Select(puMinute).selectByValue(picMinute);
    }

    public void selectDropOffTime(String dropHour, String dropMinute) {
        new Select(doHour).selectByValue(dropHour);
        new Select(doMinute).selectByValue(dropMinute);
    }


}
