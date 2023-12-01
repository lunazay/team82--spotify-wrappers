package use_case;

import api.SpotDevelopDB;
import data_access.UserDataAccessObject;
import entity.Album;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static org.junit.Assert.*;

/**
 * This class contains tests for the TopAlbum use case.
 */

public class TopAlbumTest {

    String id = "..."; // TODO get id

    /**
     * The main method to execute the test.
     *
     * @param args Command-line arguments.
     * @throws IOException If an I/O error occurs.
     */
    public static void main(String[] args) throws IOException {

        SpotDevelopDB api = new SpotDevelopDB();
        String myAuthCode = "..."; // TODO get my code
        System.out.println(api.getAuthorizationToken(myAuthCode));

    }

    /**
     * Retrieves the top albums for a user.
     *
     * @return ArrayList of top albums.
     * @throws Exception If an error occurs during data retrieval.
     */
    public ArrayList<Album> getTopAlbums() throws Exception {

        UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
        ArrayList<Album> topAlbums = userDataAccessObject.getTopAlbums(id, "long_term");
        return topAlbums;

    }

    /**
     * Test method for the getTopAlbums function.
     *
     * @throws Exception If an error occurs during the test.
     */
    @org.junit.Test
    public void testTopAlbum() throws Exception {

        ArrayList<Album> topAlbums = getTopAlbums();
        assert(Objects.equals(topAlbums.get(0).getName(), "...")); //TODO input my top album

    }

}


