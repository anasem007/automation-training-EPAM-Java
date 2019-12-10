package by.bsu.anasem.test;

import by.bsu.anasem.model.CarBookingCriteria;
import by.bsu.anasem.page.HomePage;
import by.bsu.anasem.service.CarBookingCreator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTest extends CommonConditions{
    private HomePage homePage = new HomePage(driver);

    @Test
    public void bookingDropOffTimeEarlierThanPickUpTime() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withoutDropOffLocation();
        homePage.inputPickUpLocation(carBookingCriteria.getPickUpLocation())
                .selectPickUpDate(carBookingCriteria.getPickUpDate())
                .selectDropOffDate(carBookingCriteria.getPickUpDate())
                .selectPickUpTime(carBookingCriteria.getPuHour(), carBookingCriteria.getPuMinute())
                .selectDropOffTime(CarBookingCriteria.getDoHour(), CarBookingCriteria.getDoMinute())
                .selectSearch();
        Assert.assertEquals("Pick-up Date must be before Drop off date", homePage.getAlertMessage());
    }

    @Test
    public void bookingCarWithEmptyDropOffLocation() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withDropOffLocation();
        homePage.inputPickUpLocation(carBookingCriteria.getPickUpLocation())
                .inputDropOffLocation(carBookingCriteria.getDropOffLocation())
                .selectPickUpDate(carBookingCriteria.getPickUpDate())
                .selectDropOffDate(carBookingCriteria.getDropOffDate())
                .selectPickUpTime(carBookingCriteria.getPuHour(), carBookingCriteria.getPuMinute())
                .selectDropOffTime(CarBookingCriteria.getDoHour(), CarBookingCriteria.getDoMinute())
                .selectSearch();
        Assert.assertEquals("Drop off Location must be specified", homePage.getAlertMessage());
    }

}
