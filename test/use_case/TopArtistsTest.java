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
        //String authcode = "AQCsJ6wUm4dzaw1XBtq-2JGN0s72LcGAIGG5GUfNY_eQLVOvaBQ9eTUaDgqvTowjY7MdvlcOs9AIeaJ6roVbtc4XQGAdLxEVqWD7FBLWkpAt2rMUJfe5RixrE56eV1HEoIKSb4ft3b6vLzhtSdrhdiC4xrwhdCftVTT0tpTOPMFJtVzc9vlsqTV2qqloGGfJeOoAFna6UOeH54jmkVLzDwAL-fOW2XGmfUI5pZ4-VbPuv5WhLb9WET6D4gvQ7HLhIa9ibebihZP9MdMAZpEZo-VQvggtld68ROFxkoxw7neUU_q04-DvwvRstyvtmvnMEO4";
        //System.out.println(api.getAuthorizationToken(authcode));
        System.out.println(api.getUserId());
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
