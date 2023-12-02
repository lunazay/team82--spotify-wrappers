package use_case;

import api.SpotDevelopDB;
import data_access.UserDataAccessObject;
import entity.Artist;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class contains tests for the RelatedArtists use case.
 */

public class RelatedArtistsTest {

    public static void main(String[] args) throws Exception {
        SpotDevelopDB api = new SpotDevelopDB();
        System.out.println(api.getAuthorizationToken("AQA_Hqap0MiTcGUfM-HEX7QcnBeVzD-G19rw9oX1dwIp7Et3b820SYQrLgC87dzEpjE4q30dSiUwwWgSSYVv5pNopyFSX5EBS2i0o7MM9b-yCMuE6gJnANE9HRy6wM8nv-hBoat1_2fDfln5PcLk9mG23ZBeZuZKeGCQZ2aY9rqRBf4sZAEP3eeE8CM6IQ00-7R7_s3OHVUuX0sHSZ_AZpwPMDnPKDXloXb9m0pmXgPYdRTCcteb7GeoImNYAZ4qy0vaZuUB3kPBxT0SwE4lp937OwWMqUWtYV8WPgzrA5ixYfqM0oOrYRqEsV7T0-xcU7M"));
    }

    public List<String> getRelatedArtists() throws Exception{
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
        List<String> relatedArtists = userDataAccessObject.getRelatedArtists("luna987654321", "short_term");
        return relatedArtists;
    }

    @org.junit.Test
    public void testAPIGetRelatedArtists() throws Exception{
        List<String> relatedArtists = getRelatedArtists();
        assert(Objects.equals(relatedArtists.get(0), "Future"));
    }
}
