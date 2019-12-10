package by.bsu.anasem.service;

import by.bsu.anasem.model.CarBookingCriteria;

import java.time.LocalDate;

public class CarBookingCreator {

    public static final String TESTDATA_PICKUP_LOCATION = "testdata.pickup.location";
    public static final String TESTDATA_DROPOFF_LOCATION = "testdata.dropoff.location";
    public static final String TESDATA_PICKUP_DATE = "testdata.pickup.date";
    public static final String TESDATA_DROPOFF_DATE = "testdata.pickup.date";
    public static final String TESTDATA_PICKUP_HOUR = "testdata.pickup.hour";
    public static final String TESTDATA_PICKUP_MINUTE = "testdata.pickup.minute";
    public static final String TESTDATA_DROPOFF_HOUR = "testdata.dropoff.hour";
    public static final String TESTDATA_DROPOFF_MINUTE = "testdata.dropoff.minute";

    public static CarBookingCriteria withDropOffLocation(){
        return new CarBookingCriteria(TestDataReader.getTestData(TESTDATA_PICKUP_LOCATION),
                TestDataReader.getTestData(TESTDATA_DROPOFF_LOCATION),
                TestDataReader.getTestData(TESDATA_PICKUP_DATE),
                TestDataReader.getTestData(TESDATA_DROPOFF_DATE),
                TestDataReader.getTestData(TESTDATA_PICKUP_MINUTE),
                TestDataReader.getTestData(TESTDATA_DROPOFF_HOUR),
                TestDataReader.getTestData(TESTDATA_DROPOFF_MINUTE),
                TestDataReader.getTestData(TESTDATA_PICKUP_HOUR));
    }

    public static CarBookingCriteria withoutDropOffLocation(){
        return new CarBookingCriteria(TestDataReader.getTestData(TESTDATA_PICKUP_LOCATION),
                TestDataReader.getTestData(TESDATA_PICKUP_DATE),
                TestDataReader.getTestData(TESDATA_PICKUP_DATE),
                TestDataReader.getTestData(TESDATA_DROPOFF_DATE),
                TestDataReader.getTestData(TESTDATA_PICKUP_MINUTE),
                TestDataReader.getTestData(TESTDATA_DROPOFF_HOUR),
                TestDataReader.getTestData(TESTDATA_DROPOFF_MINUTE),
                TestDataReader.getTestData(TESTDATA_PICKUP_HOUR));
    }

}
