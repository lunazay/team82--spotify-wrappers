package view;

import api.SpotDevelopDB;
import data_access.UserDataAccessObject;

import java.net.MalformedURLException;

public class LoginTest {

    UserDataAccessObject dataAccessObject = new UserDataAccessObject();
    SpotDevelopDB api = new SpotDevelopDB();

    String link = api.getAuthorizationLink();

    public LoginTest() throws MalformedURLException {
        System.out.println(link);
    }

    @org.junit.Test
    public void testSetToken() {

    }
}
