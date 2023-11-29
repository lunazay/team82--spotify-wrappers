package view;

import api.SpotDevelopDB;
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

    SpotDevelopDB api = new SpotDevelopDB();
    private final String timeframe = "short_term";
    public static void main(String[] args) throws IOException {
        SpotDevelopDB api = new SpotDevelopDB();
        System.out.println(api.getAuthorizationLink());
        String authCode = "AQD8tCOuYth3H3LLWyfJOQb0ScNXj-bRBqvzNOFPt3_5gLQERNltntdoY8j2X5CrfUZSHaJVaz2UaU0WJtdR3nmwe986mIuRoPc2B5Mn1gfnqDE9GM8Om88XlJDvc83AwHIIK4yWNoLMWoWZO2Gxbxnk3Kmn2mmopYAUMh3YjQUg4I1ZhEYYLLJ6a4IcZNvNaWQ0TtarI3v5ZZhIIifq5L56G2fVDc1ZzbZxZs9HobbLSAyN4Id2kCNDe4mwkiB5C8IRG9GD2UsjTEoQslsLumTnP4vjIpTdvaHPHVrsXaNunhMxTF4pJJPRm231ZN5QeR8";
        System.out.println(api.getAuthorizationToken(authCode));
        System.out.println(api.getUserId());
    }
    @org.junit.Test
    public void testAPIGetRelatedArtists() throws Exception{
        Artist[] artists = api.getTopArtists(timeframe);
        List<String> relatedArtists = new ArrayList<>();
        assert(artists[0].getRelatedArtists().equals(relatedArtists));
    }

}
