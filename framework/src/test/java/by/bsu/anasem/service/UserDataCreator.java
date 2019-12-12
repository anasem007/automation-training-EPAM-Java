package by.bsu.anasem.service;

import by.bsu.anasem.model.CarBookingCriteria;
import by.bsu.anasem.model.UserData;

public class UserDataCreator {

    public static final String TESTDATA_USER_EMAIL = "testdata.user.email";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";

    public static UserData withCorrectData() {
        return new UserData(TestDataReader.getTestData(TESTDATA_USER_EMAIL),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }
}
