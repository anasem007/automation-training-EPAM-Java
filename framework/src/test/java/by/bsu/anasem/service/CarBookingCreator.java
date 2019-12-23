package by.bsu.anasem.service;

import by.bsu.anasem.model.CarBookingCriteria;

import java.time.LocalDate;

public class CarBookingCreator {

    public static final String TESTDATA_PICKUP_LOCATION = "testdata.pickup.location";
    public static final String TESDATA_PICKUP_DATE = "testdata.pickup.date";
    public static final String TESDATA_DROPOFF_DATE = "testdata.dropoff.date";
    public static final String TESTDATA_PICKUP_HOUR = "testdata.pickup.hour";
    public static final String TESTDATA_PICKUP_MINUTE = "testdata.pickup.minute";
    public static final String TESDATA_CURRENT_PICKUP_DATE = "testdata.current.pickup.date";
    public static final String TESTDATA_CURRENT_PICKUP_HOUR = "testdata.current.pickup.hour";
    public static final String TESTDATA_CURRENT_PICKUP_MINUTE = "testdata.current.pickup.minute";
    public static final String TESTDATA_DROPOFF_HOUR = "testdata.dropoff.hour";
    public static final String TESTDATA_DROPOFF_DATE_GREATER_PICKUP_FOR_OME_MONTH = "testdata.dropoff.location.faraway";
    public static final String TESTDATA_PICKUP_HOUR_PLACE_CLOSER = "testdata.pickup.hour.place.closer";
    public static final String TESTDATA_DROPOFF_HOUR_PLACE_CLOSER = "testdata.return.hour.place.closer";
    public static final String TESTDATA_DRIVERS_AGE = "testdata.drivers.age";


    public static CarBookingCriteria withEmptyDropOffLocation(){
        return new CarBookingCriteria(TestDataReader.getTestData(TESTDATA_PICKUP_LOCATION),
                null,
                TestDataReader.getTestData(TESDATA_PICKUP_DATE),
                TestDataReader.getTestData(TESDATA_DROPOFF_DATE));
    }

    public static CarBookingCriteria withCurrentTime(){
        return new CarBookingCriteria(TestDataReader.getTestData(TESTDATA_PICKUP_LOCATION),
                TestDataReader.getTestData(TESDATA_CURRENT_PICKUP_DATE),
                TestDataReader.getTestData(TESDATA_DROPOFF_DATE),
                TestDataReader.getTestData(TESTDATA_CURRENT_PICKUP_HOUR),
                TestDataReader.getTestData(TESTDATA_CURRENT_PICKUP_MINUTE),
                TestDataReader.getTestData(TESTDATA_DROPOFF_HOUR),
                TestDataReader.getTestData(TESTDATA_PICKUP_MINUTE));
    }

    public static CarBookingCriteria withoutDropOffLocation(){
        return new CarBookingCriteria(TestDataReader.getTestData(TESTDATA_PICKUP_LOCATION),
                TestDataReader.getTestData(TESDATA_PICKUP_DATE),
                TestDataReader.getTestData(TESDATA_DROPOFF_DATE),
                TestDataReader.getTestData(TESTDATA_PICKUP_HOUR),
                TestDataReader.getTestData(TESTDATA_PICKUP_MINUTE),
                TestDataReader.getTestData(TESTDATA_DROPOFF_HOUR),
                TestDataReader.getTestData(TESTDATA_PICKUP_MINUTE));
    }

    public static CarBookingCriteria withSameTime(){
        return new CarBookingCriteria(TestDataReader.getTestData(TESTDATA_PICKUP_LOCATION),
                TestDataReader.getTestData(TESDATA_PICKUP_DATE),
                TestDataReader.getTestData(TESDATA_PICKUP_DATE),
                TestDataReader.getTestData(TESTDATA_PICKUP_HOUR),
                TestDataReader.getTestData(TESTDATA_PICKUP_MINUTE),
                TestDataReader.getTestData(TESTDATA_PICKUP_HOUR),
                TestDataReader.getTestData(TESTDATA_PICKUP_MINUTE));
    }

    public static CarBookingCriteria withDriversAge(){
        return new CarBookingCriteria(TestDataReader.getTestData(TESTDATA_PICKUP_LOCATION),
                TestDataReader.getTestData(TESTDATA_DRIVERS_AGE));
    }

    public static CarBookingCriteria withCloserTime(){
        return new CarBookingCriteria(TestDataReader.getTestData(TESTDATA_PICKUP_LOCATION),
                TestDataReader.getTestData(TESDATA_PICKUP_DATE),
                TestDataReader.getTestData(TESDATA_DROPOFF_DATE),
                TestDataReader.getTestData(TESTDATA_PICKUP_HOUR_PLACE_CLOSER),
                TestDataReader.getTestData(TESTDATA_PICKUP_MINUTE),
                TestDataReader.getTestData(TESTDATA_DROPOFF_HOUR_PLACE_CLOSER),
                TestDataReader.getTestData(TESTDATA_PICKUP_MINUTE));
    }

    public static CarBookingCriteria withDropOffDateGreaterThanPickUpForOneMonth(){
        return new CarBookingCriteria(TestDataReader.getTestData(TESTDATA_PICKUP_LOCATION),
                TestDataReader.getTestData(TESDATA_PICKUP_DATE),
                TestDataReader.getTestData(TESTDATA_DROPOFF_DATE_GREATER_PICKUP_FOR_OME_MONTH),
                TestDataReader.getTestData(TESTDATA_PICKUP_HOUR),
                TestDataReader.getTestData(TESTDATA_PICKUP_MINUTE),
                TestDataReader.getTestData(TESTDATA_DROPOFF_HOUR),
                TestDataReader.getTestData(TESTDATA_PICKUP_MINUTE));
    }


}
