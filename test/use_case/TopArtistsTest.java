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
        System.out.println(api.getAuthorizationToken("AQBCsPsKpEtTwzqMWZuMbQ0EgaXNQjPMjNWy5XW8dQQLlZZJxefETc5uTkbYevUhwCHDGUBZpVpZWYttEwFcaz00fz4kXBpLOvtYSfwwN3q6xE8vs5mEe-yi320G1jpY_3fq6TdnJ9_xeoQLeYeVlTrgTgga43A_6AF9vL7V1iQ3x3QpqPyKMd8Ux0mofZOZcIXGuvAmvN3ajk9iRrFb41cSgJdkHjTCN53qH92NhFzbPbvOO5b7kts5gDxRM4GGW0T9BRKrhRvNmyiD8Ah6qoGx029NeqohBiUyDlf4gyDBDXbkewzrFR0T5po49REI-Q4"));
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
