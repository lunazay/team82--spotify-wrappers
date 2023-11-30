package use_case;

import java.io.IOException;
import java.util.Objects;

import api.SpotDevelopDB;
import data_access.UserDataAccessObject;
import entity.Artist;

public class TopGenreTest {
    public static void main(String[] args) throws IOException {
        SpotDevelopDB api = new SpotDevelopDB();
        String authcode = "AQAfsKwkY2w0Aa0CtY_7EN_E4p2JuGyMIvg1TCD6clY_d8cH7PIazRvS_i2Ur2ZoKpbjmavmk88sAMkFukURwKcjVEBUsGFc78V0r3i-HNSjrdy1Bdvl0xC3K8Q45uPN211dO7hts5SesnZJnI3rfi8jCjPtsEUr4Lj-7rc7jxmWrJMzu0pDwAMKyMjRHDJ53nqFkWkj5q57oMXgmHZA5qnWISeckWmUm9XFGeqbmf7f1X2co3GYLWudewJayLmvn7aV95b4uu-jI9Jk1PWXCnoHkk9SpgHw8iKZYnee6Ne63fG6lPODnFb7OaBije0-rnU";
        System.out.println(api.getAuthorizationToken(authcode));
    }
}
