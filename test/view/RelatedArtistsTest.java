package view;

import api.SpotDevelopDB;
import data_access.UserDataAccessObject;
import entity.Artist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


public class RelatedArtistsTest {

    private final String timeframe = "short_term";
    public static void main(String[] args) throws Exception {
        SpotDevelopDB api = new SpotDevelopDB();
        UserDataAccessObject user = new UserDataAccessObject();

        System.out.println(api.getAuthorizationLink());
        //String authCode = "AQDw4FdjcQ6UpU8pnvUhUulPcqzxT8nJLVu3hVWd4EYLfmQ4VOqiMxzuWGDY-8HglMAzpVW9g3LppICJulqbQa5IGhALoWJJGrDItWBKqpFfA4MsTkxm-IWOzDQNiAq66hO9lhuyBPn4KDtsiba-ajIgrKRSVjx24X9OkAtj7Lc-s37N_V6mENyqzep1bqIdE1Vq77mfmAeTxIQ6Lz24Rh8Rge-bRa266Ep8LfEWYO4zpuWJHL0sPxRxHAH-AU_Buouy8A5IDJYzMUprt54veUtzo8Je2vaU1lXpScMVaA1Hg0Z6sWQpqXejDB0THEoJT1s";
        //System.out.println(api.getAuthorizationToken(authCode));
        System.out.println(api.getUserId());

        System.out.println(user.getTopArtists("31gqehqotfmiji3bbkreneh7d3ia","medium_term"));
        System.out.println(user.getTopGenres("31gqehqotfmiji3bbkreneh7d3ia", "short_term"));
    }

//    @org.junit.Test
//    public void testAPIGetRelatedArtists() throws Exception{
//        Artist[] artists = api.getTopArtists(timeframe);
//        List<String> relatedArtists = new ArrayList<>();
//        assert(artists[0].getRelatedArtists().equals(relatedArtists));
//    }

}
