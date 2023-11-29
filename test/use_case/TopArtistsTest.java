package use_case;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

import api.SpotDevelopDB;
import data_access.UserDataAccessObject;
import entity.Artist;

public class TopArtistsTest {

    public static void main(String[] args) throws IOException {
        SpotDevelopDB api = new SpotDevelopDB();
        System.out.println(api.getAuthorizationToken("AQCGSB3LXNNDCb40PqWkpkIaenqg1DE5yqpS3wkRJneTLKwWaXipA-zcKSKpDLfhMsdUIaq-V2KOs-0mTBMzAwDUphm-4XEiHNngCZCDH-VuH6k3xwvRiilIcgP0O2RUA8LBzncLy_EMpTwW_OdW9ShfrA6MBNttWkwo36GceEQvgqKs8xDgMxoKcfC3eIaMJJWnnzYI3xnduGGBjeB_GNFdrU1pbIurQe76ZyzM5ew_GJToqylr2o2HAa7A9-jjMVUxjdLLuH6gsH8fg4MuSoh_2lsRiCEJTgOkhIYLlTb0oLW-lpq8qTAQwlXzvep1QAI"));
    }

    @org.junit.Test
    public void testTopArtist() throws Exception {
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject();

        Artist[] topArtists = userDataAccessObject.getTopArtists("0wn1qh223kptm533gbxyin4mh", "long_term");
        assert(Objects.equals(topArtists[0].getName(), "Paloma Faith"));
    }
}
