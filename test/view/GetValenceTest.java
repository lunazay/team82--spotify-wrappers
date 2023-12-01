package view;

import api.SpotDevelopDB;
import app.Main;
import data_access.UserDataAccessObject;
import interface_adapter.get_valence.GetValencePresenter;
import interface_adapter.get_valence.GetValenceViewModel;
import org.junit.Test;
import use_case.get_valence.GetValenceDataAccessInterface;
import use_case.get_valence.GetValenceInteractor;
import use_case.get_valence.GetValenceOutputBoundary;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class GetValenceTest {

    // TODO: may have to separate the "empty" cases from the rest of the cases

    String emptyId = "312x6t6bf2nas7jiahsll6ajmjba"; // this is the id for my empty tester account
    String songId = "11dFghVXANMlKmJXsNCbNl"; // sample song id provided by spotify
    String nonEmptyId = "0wn1qh223kptm533gbxyin4mh"; // jack's account
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
        System.out.println(userDataAccessObject.getValence(nonEmptyId, "long_term"));
        // TODO: replace above with proper values.
    }

    // Testing the interactor:

}
