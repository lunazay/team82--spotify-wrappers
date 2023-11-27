package view;

import api.SpotDevelopDB;
import data_access.UserDataAccessObject;

import java.io.IOException;
import java.net.MalformedURLException;

public class LoginTest {

    UserDataAccessObject dataAccessObject = new UserDataAccessObject();
    SpotDevelopDB api = new SpotDevelopDB();
    String link = api.getAuthorizationLink();

    String code = "AQD3v_pPZZjqsJnz-GzZk-oWFvBV5ILpsxfuElHYNlzzLCKj1vg4zaK-mzZ-lQARrO0jV3HSRC-mVh-rk0KMkav6Hv4rAT43vRJ4A49MAO1A0x56dIWAfmD_U-lhK4uJM9du6tkDC42N6UA-FZl4EBY1eTYm8vlx1zr6V1noMAf9EKNeHsNVmmqskmcgO1qDG0zf3CBOvCLSzKoN8PUCbzH0JsocXK4171S7y7cbaYpar3FkAiCMQJ1DyP-45ETFuSv6esQUplzJ9Hsoz_K_2Q2XWB0aVkzYGL27Tr9eVdI3Jz7gV3uauFo1mT-SNdzHHKg";

    public LoginTest() throws MalformedURLException {
        System.out.println(link);
    }

    @org.junit.Test
    public void testSetToken() throws IOException {
        System.out.println(api.token());
        // dataAccessObject.setToken(code);
        System.out.println(api.token());
    }
}
