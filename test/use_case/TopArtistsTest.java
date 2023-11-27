package use_case;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import data_access.UserDataAccessObject;
import entity.Artist;
import org.junit.Assert;;

public class TopArtistsTest {

    /**
     * Tests whether the getTopArtists() method in data_access/UserDataAccessObject.java and api/SpotDevelopDB.java
     * construct an array of Artist objects correctly.
     */
    @org.junit.Test
    public void testTopArtist() throws Exception {
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
        // Authenticate user
        Artist[] topArtists = userDataAccessObject.getTopArtists("0wn1qh223kptm533gbxyin4mh", "long_term");
        assert(Objects.equals(topArtists[0].getName(), "Paloma Faith"));
    }
}
