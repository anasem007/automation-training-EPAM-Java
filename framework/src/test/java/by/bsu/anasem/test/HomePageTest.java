package by.bsu.anasem.test;

import by.bsu.anasem.model.CarBookingCriteria;
import by.bsu.anasem.model.UserData;
import by.bsu.anasem.page.HomePage;
import by.bsu.anasem.service.CarBookingCreator;
import by.bsu.anasem.service.UserDataCreator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTest extends CommonConditions{
    private static final Logger logger = LogManager.getLogger(HomePageTest.class);
    private HomePage homePage = new HomePage(driver);

    @Test
    public void bookingDropOffTimeEarlierThanPickUpTime() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withoutDropOffLocation();
        homePage.openPage()
                .inputPickUpLocation(carBookingCriteria.getPickUpLocation())
                .selectPickUpDate(carBookingCriteria.getPickUpDate())
                .selectDropOffDate(carBookingCriteria.getPickUpDate())
                .selectPickUpTime(carBookingCriteria.getPuHour(), carBookingCriteria.getPuMinute())
                .selectDropOffTime(carBookingCriteria.getDoHour(), carBookingCriteria.getDoMinute())
                .redirectToHomePage();
        Assert.assertEquals("Pickup Date must be before Drop off date\n", homePage.getAlertMessage());
        logger.log(Level.INFO, "Test booking drop off time earlier than pick up time was completed");
    }

    /*@Test
    public void bookingCarWithEmptyDropOffLocation() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withEmptyDropOffLocation();
        homePage.inputPickUpLocation(carBookingCriteria.getPickUpLocation())
                .inputDropOffLocation(carBookingCriteria.getDropOffLocation())
                .selectPickUpDate(carBookingCriteria.getPickUpDate())
                .selectDropOffDate(carBookingCriteria.getDropOffDate())
                .redirectToHomePage();
        Assert.assertEquals("Drop off Location must be specified", homePage.getAlertMessage());
        logger.log(Level.INFO, "Test booking car with empty drop off location was completed");

    }

    @Test
    public void pickUpTimeStartsInFewMinutes() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withCurrentTime();
        homePage.inputPickUpLocation(carBookingCriteria.getPickUpLocation())
                .selectPickUpDate(carBookingCriteria.getPickUpDate())
                .selectDropOffDate(carBookingCriteria.getPickUpDate())
                .selectPickUpTime(carBookingCriteria.getPuHour(), carBookingCriteria.getPuMinute())
                .selectDropOffTime(carBookingCriteria.getDoHour(), carBookingCriteria.getDoMinute())
                .redirectToHomePage();
        Assert.assertEquals("Pick-up time must be at least 1 hour in the future", homePage.getAlertMessage());
        logger.log(Level.INFO, "Test pick up time starts in few minutes was completed");
    }

    @Test
    public void pickUpDateAndTimeCoincidesWithDropOff() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withSameTime();
        homePage.inputPickUpLocation(carBookingCriteria.getPickUpLocation())
                .selectPickUpDate(carBookingCriteria.getPickUpDate())
                .selectDropOffDate(carBookingCriteria.getPickUpDate())
                .selectPickUpTime(carBookingCriteria.getPuHour(), carBookingCriteria.getPuMinute())
                .selectDropOffTime(carBookingCriteria.getPuHour(), carBookingCriteria.getPuMinute())
                .redirectToHomePage();
        Assert.assertEquals("There must be at least one hour between pick up and drop off", homePage.getAlertMessage());
        logger.log(Level.INFO, "Test pick up date and time coincides with drop off date and time was completed");
    }

    @Test
    public void driverAgeIsLessThanEighteen() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withDriversAge();
        homePage.inputPickUpLocation(carBookingCriteria.getPickUpLocation())
                .selectDriversAge(carBookingCriteria.getDriversAge())
                .redirectToHomePage();
        Assert.assertEquals("Driver's age must be  at least 18", homePage.getAlertMessage());
        logger.log(Level.INFO, "Test driver age is less tha eighteen was completed");
    }

    @Test
    public void signInWithValidNonRegisteredData() {
        UserData userData = UserDataCreator.withCorrectData();
        homePage.clickToSignInYourAccount()
                .inputEmail(userData.getEmail())
                .inputPassword(userData.getPassword())
                .clickSignInButton();
        Assert.assertEquals("Invalid email address or password. Please check your details and try again.",
                homePage.getLoginErrorMessage());
        logger.log(Level.INFO, "Test sign in with valid nod registered data was completed");
    }

    @Test
    public void bookingPeriodGreaterThanOneMonth() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withDropOffDateGreaterThanPickUpForOneMonth();
        homePage.inputPickUpLocation(carBookingCriteria.getPickUpLocation())
                .inputDropOffLocation(carBookingCriteria.getDropOffLocation())
                .selectPickUpDate(carBookingCriteria.getPickUpDate())
                .selectDropOffDate(carBookingCriteria.getDropOffDate())
                .selectPickUpTime(carBookingCriteria.getPuHour(), carBookingCriteria.getPuMinute())
                .selectDropOffTime(carBookingCriteria.getDoHour(), carBookingCriteria.getDoMinute())
                .redirectToHomePage();
        Assert.assertEquals("Sorry, rentals of 31 days or more aren't available to be booked online.",
                homePage.getAlertMessage());
        logger.log(Level.INFO, "Test bookingperiod greater than one month was completed");
    }*/

}
