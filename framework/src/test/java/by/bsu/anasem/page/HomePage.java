package by.bsu.anasem.page;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends AbstractPage {

    private final String HOMEPAGE_URL = "https://www.rentalcars.com/en/";
    private final Logger logger = LogManager.getRootLogger();

    @Override
    public HomePage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        logger.info("Home page opened");
        return this;
    }

    @FindBy(xpath = "//input[@id='ftsAutocomplete']")
    private WebElement pickUpLocation;

    @FindBy(xpath = "//input[@id='returntolocation']")
    private WebElement dropOffLocationButton;

    @FindBy(xpath = "//input[@id='dropFtsAutocomplete']")
    private WebElement dropOffLocation;

    @FindBy(xpath = "//input[@id='pu-short-date']")
    private WebElement pickUpDate;

    @FindBy(xpath = "//input[@id='do-short-date']")
    private WebElement dropOffDate;

    @FindBy(xpath = "//select[@id='puHour']")
    private WebElement puHour;

    @FindBy(xpath = "//select[@id='puMinute']")
    private WebElement puMinute;

    @FindBy(xpath = "//select[@id='doHour']")
    private WebElement doHour;

    @FindBy(xpath = "//select[@id='doMinute']")
    private WebElement doMinute;

    @FindBy(xpath = "//input[@id='formsubmit']")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public HomePage inputPickUpLocation(String pickLoc) {
        pickUpLocation.sendKeys(pickLoc);
        return this;
    }

    public HomePage inputDropOffLocation(String pickLoc) {
        dropOffLocationButton.click();
        pickUpLocation.sendKeys(pickLoc);
        return this;
    }

    public HomePage selectPickUpDate(String picDate) {
        dropOffDate.sendKeys(picDate);
        return this;
    }

    public HomePage selectDropOffDate(String dropDate) {
        dropOffDate.sendKeys(dropDate);
        return this;
    }

    public CarSelectionPage clickCorrectSearch() {
        searchButton.click();
        return new CarSelectionPage(driver);
    }

    public HomePage clickSearch() {
        searchButton.click();
        return this;
    }

    public HomePage selectPickUpTime(String picHour, String picMinute) {
        new Select(puHour).selectByValue(picHour);
        new Select(puMinute).selectByValue(picMinute);
        return this;
    }

    public HomePage selectDropOffTime(String dropHour, String dropMinute) {
        new Select(doHour).selectByValue(dropHour);
        new Select(doMinute).selectByValue(dropMinute);
        return this;
    }

    public String getAlertMessage() {
        return driver.switchTo().alert().getText();
    }
}
