package by.bsu.anasem.test;

import by.bsu.anasem.model.CarBookingCriteria;
import by.bsu.anasem.page.HomePage;
import by.bsu.anasem.service.CarBookingCreator;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class CarSelectionPageTest extends CommonConditions {
    private HomePage homePage = new HomePage(driver);
    private final Logger logger = (Logger) LogManager.getRootLogger();

    /*@Test
    public void bookingPlaceClosedAtTheRequestedHours() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withCloserTime();
        String bookingInfoPlaceClosed = homePage.bookingCar(carBookingCriteria).getInfoMessage();
        Assert.assertEquals("Sorry, but the companies we work with in" +
                "\n" + "Minsk International Airport (MSQ) closed" +
                "\n" + "on Wednesday at 08:00 and on Thursday at 08:00.", bookingInfoPlaceClosed);
        logger.log(Level.INFO, "Test booking place closed at the requested hours was completed");
    }

    @Test
    public void noCarsAvailable() {
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withoutDropOffLocation();
        String infoMessage = homePage.bookingCar(carBookingCriteria).getInfoMessage();
        Assert.assertEquals("We're sorry, but the companies we work with in" + carBookingCriteria.getPickUpLocation()+
                "don't have any cars available.", infoMessage);
        logger.log(Level.INFO, "Test no cars available was completed");
    }

    @Test void rentAndReturnCarInTheSamePlace(){
        CarBookingCriteria carBookingCriteria = CarBookingCreator.withoutDropOffLocation();
        Assert.assertTrue(homePage.bookingCar(carBookingCriteria).getCars());
        logger.log(Level.INFO, "Test rent and return car in the same place was completed");
    }*/
}
