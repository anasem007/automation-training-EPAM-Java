package by.bsu.anasem.page;

import by.bsu.anasem.model.CarBookingCriteria;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//input[@id='driver-over-min-age']")
    private WebElement driversAgeButton;

    @FindBy(xpath = "//button[@id='rch-select-sign-in']")
    private  WebElement selectSignIn;

    @FindBy(xpath = "//input[@id='crmEmail']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='crmPsw']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='crmLogin']")
    private WebElement login;

    @FindBy(xpath = "//div[@id='showLoginErrorMessage']")
    private WebElement errorMessage;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public HomePage clickToSignInYourAccount(){
        selectSignIn.click();
        return this;
    }

    public HomePage inputEmail(String emailAdress){
        email.sendKeys(emailAdress);
        return this;
    }

    public HomePage inputPassword(String userPassword){
        password.sendKeys(userPassword);
        return this;
    }

    public CarSelectionPage bookingCar(CarBookingCriteria carBookingCriteria) {
        inputPickUpLocation(carBookingCriteria.getPickUpLocation())
                .selectPickUpTime(carBookingCriteria.getPuHour(), carBookingCriteria.getPuMinute())
                .selectDropOffTime(carBookingCriteria.getDoHour(), carBookingCriteria.getDoMinute())
                .redirectToCarSelectionPage();
        logger.log(Level.INFO, "Car selection page performed.");
        return new CarSelectionPage(driver);
    }

    public HomePage clickSignInButton(){
        login.click();
        return this;
    }

    public String getLoginErrorMessage(){
        return errorMessage.getText();
    }

    public HomePage selectDriversAge(String driversAge) {
        driversAgeButton.click();
        driver.findElement(By.xpath("//input[@id='driver-age-input']")).sendKeys(driversAge);
        return this;
    }

    public HomePage inputPickUpLocation(String pickLoc) {
        pickUpLocation.sendKeys(pickLoc);
        logger.info("Filled 'Pick-up location' field with " + pickLoc);
        return this;
    }

    public HomePage inputDropOffLocation(String dropLoc) {
        dropOffLocationButton.click();
        pickUpLocation.sendKeys(dropLoc);
        logger.info("Filled 'Drop Off location' field with " + dropLoc);
        return this;
    }

    public HomePage selectPickUpDate(String picDate) {
        dropOffDate.sendKeys(picDate);
        logger.info("Filled 'Pick-up date' field with " + picDate);
        return this;
    }

    public HomePage selectDropOffDate(String dropDate) {
        dropOffDate.sendKeys(dropDate);
        logger.info("Filled 'Drop off date' field with " + dropDate);
        return this;
    }

    public CarSelectionPage redirectToCarSelectionPage() {
        searchButton.click();
        return new CarSelectionPage(driver);
    }

    public HomePage redirectToHomePage() {
        searchButton.click();
        logger.log(Level.INFO, "Car selection page performed.");
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
