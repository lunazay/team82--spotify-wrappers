package view;

import api.SpotDevelopDB;
import app.Main;
import data_access.UserDataAccessObject;

import javax.swing.*;

public class GetValenceTest {

    String id = "312x6t6bf2nas7jiahsll6ajmjba"; // this is the id for my tester account
    String songId = "11dFghVXANMlKmJXsNCbNl"; // sample song id provided by spotify
    UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
    SpotDevelopDB api = new SpotDevelopDB();
    @org.junit.Test
    public void testApiGetValence() throws Exception {
        assert(api.get_valence(songId).equals("0.625")); // sample song has 0.625 valence
    }

}
