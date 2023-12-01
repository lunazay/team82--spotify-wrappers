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

public class TopAlbumTest {

    String id = "..."; // TODO get id
    public static void main(String[] args) throws IOException {

        SpotDevelopDB api = new SpotDevelopDB();
        String myAuthCode = "..."; // TODO get my code
        System.out.println(api.getAuthorizationToken(myAuthCode));

    }

    public ArrayList<Album> getTopAlbums() throws Exception {

        UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
        ArrayList<Album> topAlbums = userDataAccessObject.getTopAlbums(id, "long_term");
        return topAlbums;

    }

    @org.junit.Test
    public void testTopAlbum() throws Exception {

        ArrayList<Album> topAlbums = getTopAlbums();
        assert(Objects.equals(topAlbums.get(0).getName(), "...")); //TODO input my top album

    }

}


