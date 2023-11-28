package use_case;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

import api.SpotDevelopDB;
import data_access.UserDataAccessObject;
import entity.Artist;
import entity.Song;
import org.junit.Assert;;

public class TopArtistsTest {

    public static void main(String[] args) throws IOException {
        SpotDevelopDB api = new SpotDevelopDB();
        //System.out.println(api.getAuthorizationLink());
        System.out.println(api.getAuthorizationToken("AQD3XOiJAoMiLYBejCoph5gfYyjT6qnojrfnMWkDW35WQVtO3_lt7l6L0CMjUqX-ongTM_Z8225uMkjkE32IhB7IisHYJv0ma5nDziUCuw4_AlrLwWZKbahftKOxfN8z7T-56kbYyeLNzeTct95L9VwFuOqJJhL9tHWFbNWw_b5GOyX7KM9MaHsHXUUpvPjee_g6KtQvWmLUZAjU2flTz1_EwK0SwoJxz7zHBVRQcfdQYNWyDPkwPXIgEUViYI33IaIecst3NlHSar53Xb8ea-AVHsCcIQP0lxpK8wl_AQ6CaHN6F08vEsUK16ItmNeHBSk"));
    }

    @org.junit.Test
    public void testTopArtist() throws Exception {
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
        SpotDevelopDB api = new SpotDevelopDB();
        String valence = api.get_valence("62ke5zFUJN6RvtXZgVH0F8");
        Artist[] topArtists = userDataAccessObject.getTopArtists("31kaxlo4ik6qs6vu3gtkb4i5iyye", "long_term");
        assert(Objects.equals(topArtists[0].getName(), "Paloma Faith"));
    }
}
