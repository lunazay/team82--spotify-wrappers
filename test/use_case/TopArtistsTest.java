package use_case;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

import api.SpotDevelopDB;
import data_access.UserDataAccessObject;
import entity.Artist;
import org.junit.Assert;;

public class TopArtistsTest {

    public static void main(String[] args) throws IOException {
        SpotDevelopDB api = new SpotDevelopDB();
        System.out.println(api.getAuthorizationLink());
        System.out.println(api.getAuthorizationToken("AQChVsKdnjpC7T_Pkd5fIcsYnJXDXMENi0VZrC9FDKGyXTLy-VFtiJ3hcCY4Y2KP4XdKDU9b7YB_BqCs6vwmWfqPTP6smC4Z4zB1H9CrHOb5pZNx0g2i5EkQhj3-GMyQGLtMZT5PVUjKb7DAGSgH6FNOO4Tp0Gbvp1fMP6msJvJ7bzrsmtr69gnleMM-_e5OPDKPgLchFMiwC6Q9iB1iB8Ve7GXJkg6wuamy-hUCaQQ"));
    }

    @org.junit.Test
    public void testTopArtist() throws Exception {
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
        SpotDevelopDB api = new SpotDevelopDB();

        Artist[] topArtists = userDataAccessObject.getTopArtists("0wn1qh223kptm533gbxyin4mh", "long_term");
        assert(Objects.equals(topArtists[0].getName(), "Paloma Faith"));
    }
}
