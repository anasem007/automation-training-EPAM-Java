package by.bsu.anasem.test;

import by.bsu.anasem.model.CarBookingCriteria;
import by.bsu.anasem.model.UserData;
import by.bsu.anasem.page.HomePage;
import by.bsu.anasem.service.CarBookingCreator;
import by.bsu.anasem.service.UserDataCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends CommonConditions {

    @Test
    public void bookingDropOffTimeEarlierThanPickUpTime() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withDropOffTimeEarlierPickUpTime();
        String str = new HomePage(driver)
                .openPage()
                .inputPickUpLocation(carBookingCriteria.getPickUpLocation())
                .selectPickUpDate(carBookingCriteria.getPickUpDate())
                .selectDropOffDate(carBookingCriteria.getDropOffDate())
                .selectPickUpTime(carBookingCriteria.getPuHour(), carBookingCriteria.getPuMinute())
                .selectDropOffTime(carBookingCriteria.getDoHour(), carBookingCriteria.getDoMinute())
                .redirectToHomePage()
                .getAlertMessage();
        Assert.assertEquals("Pickup Date must be before Drop off date\n", str);
    }

   /* @Test
    public void bookingCarWithEmptyDropOffLocation() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withEmptyDropOffLocation();
        String str = new HomePage(driver)
                .openPage()
                .inputPickUpLocation(carBookingCriteria.getPickUpLocation())
                .inputDropOffLocation(carBookingCriteria.getDropOffLocation())
                .selectPickUpDate(carBookingCriteria.getPickUpDate())
                .selectDropOffDate(carBookingCriteria.getDropOffDate())
                .redirectToHomePage()
                .getAlertMessage();
        Assert.assertEquals("Drop off Location must be specified\n", str);
    }

    @Test
    public void pickUpTimeStartsInFewMinutes() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withCurrentTime();
        String str = new HomePage(driver)
                .openPage()
                .inputPickUpLocation(carBookingCriteria.getPickUpLocation())
                .selectPickUpDate(carBookingCriteria.getPickUpDate())
                .selectDropOffDate(carBookingCriteria.getDropOffDate())
                .selectPickUpTime(carBookingCriteria.getPuHour(), carBookingCriteria.getPuMinute())
                .selectDropOffTime(carBookingCriteria.getDoHour(), carBookingCriteria.getDoMinute())
                .redirectToHomePage()
                .getAlertMessage();
        Assert.assertEquals("Pick-up time must be at least 1 hour in the future\n", str);
    }

    @Test
    public void pickUpDateAndTimeCoincidesWithDropOff() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withSameTime();
        String str = new HomePage(driver)
                .openPage()
                .inputPickUpLocation(carBookingCriteria.getPickUpLocation())
                .selectPickUpDate(carBookingCriteria.getPickUpDate())
                .selectDropOffDate(carBookingCriteria.getDropOffDate())
                .selectPickUpTime(carBookingCriteria.getPuHour(), carBookingCriteria.getPuMinute())
                .selectDropOffTime(carBookingCriteria.getPuHour(), carBookingCriteria.getPuMinute())
                .redirectToHomePage()
                .getAlertMessage();
        Assert.assertEquals("There must be at least one hour between pick up and drop off\n", str);
    }

    @Test
    public void driverAgeIsLessThanEighteen() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withDriversAge();
        String str = new HomePage(driver)
                .openPage()
                .inputPickUpLocation(carBookingCriteria.getPickUpLocation())
                .selectDriversAge(carBookingCriteria.getDriversAge())
                .redirectToHomePage()
                .getAlertMessage();
        Assert.assertEquals("Driver's age must be  at least 18\n", str);
    }

    /*@Test
    public void signInWithValidNonRegisteredData() {
        UserData userData = UserDataCreator.withCorrectData();
        homePage.clickToSignInYourAccount()
                .inputEmail(userData.getEmail())
                .inputPassword(userData.getPassword())
                .clickSignInButton();
        Assert.assertEquals("Invalid email address or password. Please check your details and try again.",
                homePage.getLoginErrorMessage());
    }*/
}
