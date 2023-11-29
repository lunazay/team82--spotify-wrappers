package view;

import api.SpotDevelopDB;
import app.Main;
import data_access.UserDataAccessObject;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class GetValenceTest {

    // TODO: may have to separate the "empty" cases from the rest of the cases

    String emptyId = "312x6t6bf2nas7jiahsll6ajmjba"; // this is the id for my empty tester account
    String songId = "11dFghVXANMlKmJXsNCbNl"; // sample song id provided by spotify
    String nonEmptyId = ""; // TODO: put an actual ID of an existing account here.
    UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
    SpotDevelopDB api = new SpotDevelopDB();

    @org.junit.Test
    public void testApiGetValence() throws Exception {
        assert(api.get_valence(songId).equals("0.625")); // sample song has 0.625 valence
    }

    @Test
    public void testGetValenceEmptyAccount() {
        // test that right exception is thrown
        Exception exception = assertThrows(Exception.class,
                () -> userDataAccessObject.getValence(emptyId, "medium_term"));
        assertEquals("Listen to some music bro!", exception.getMessage());
    }

    @Test
    public void testGetValenceNonEmpty() throws Exception {
        assertEquals(userDataAccessObject.getValence(nonEmptyId, "long_term"), "0.500");
        // TODO: replace above with proper values.
    }

    // Testing the interactor:

}
