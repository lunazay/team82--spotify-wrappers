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
        // System.out.println(api.getAuthorizationLink());
        System.out.println(api.getAuthorizationToken("AQBhr6HWspsATawY3yrlGUSh1q8-eABfgj1-7tcX4BNtuEq6ZNEA3Fdr78KfLcQo1lUkV5dSIt4_2Znvi_vMbW3TUeh4E9-bDVOEbAllDdsLpzyNVhYKpy1M3HygosWM7hd2o3W9JUlCOsHqAtNxk3esPnnJLxsSksqLsKeTw6xUFfr9WBHdkzfpuw2P3rF9cSIG_CPOftL2YbN8qEfHtOYv95VWWy8RYigyrmYVMhPUlb4-nrKjCMqEi_oMNU74WzphEqhwGIPPfOkFWuPtDmpykGkhwIHzCanunR8zSK31apXZIGHPNbvmyAz4crTxvVg"));
    }

    @org.junit.Test
    public void testTopArtist() throws Exception {
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
        SpotDevelopDB api = new SpotDevelopDB();

        Artist[] topArtists = userDataAccessObject.getTopArtists("0wn1qh223kptm533gbxyin4mh", "long_term");
        assert(Objects.equals(topArtists[0].getName(), "Paloma Faith"));
    }
}
