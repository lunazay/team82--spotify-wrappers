package view;

import api.SpotDevelopDB;
import data_access.UserDataAccessObject;

import java.io.IOException;
import java.net.MalformedURLException;

public class LoginTest {

    UserDataAccessObject dataAccessObject = new UserDataAccessObject();
    SpotDevelopDB api = new SpotDevelopDB();
    String link = api.getAuthorizationLink();

    String code = "AQDrR7RGecdLg_OFnX8cy9YI5DLeC1s2L3mr8oSA-WgBiagxYj28jbkT9HGl7rBZvMHu-bBIOSkDltJMawHxWRMcfeperTAfiNbW-2A2ZWAkV1F6AfplZDVv920wkj79uglUoWktZuVLc_qk9mxjViO7300pb_MXMgJyTKAEIvy2LZw336kRu157A_OkykHhAvICXN0hWKvumGBZjP8E2STuE2RJnBe4VM9x96jRuT5t1ScnHZxkN5HssbxfAR2GtfJAWpjZfECku-46jatfcAxg7LHQBK4R_g7BBm5BkyM9TreCXXDYB7y_2zIpP0FfpBw";

    public LoginTest() throws MalformedURLException {
        System.out.println(link);
    }

    @org.junit.Test
    public void testSetToken() throws IOException {
        System.out.println(api.token());
        dataAccessObject.setToken(code);
        System.out.println(api.token());
    }
}
