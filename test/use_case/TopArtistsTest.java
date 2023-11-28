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
        System.out.println(api.getAuthorizationLink());
        String authCode = "AQD8tCOuYth3H3LLWyfJOQb0ScNXj-bRBqvzNOFPt3_5gLQERNltntdoY8j2X5CrfUZSHaJVaz2UaU0WJtdR3nmwe986mIuRoPc2B5Mn1gfnqDE9GM8Om88XlJDvc83AwHIIK4yWNoLMWoWZO2Gxbxnk3Kmn2mmopYAUMh3YjQUg4I1ZhEYYLLJ6a4IcZNvNaWQ0TtarI3v5ZZhIIifq5L56G2fVDc1ZzbZxZs9HobbLSAyN4Id2kCNDe4mwkiB5C8IRG9GD2UsjTEoQslsLumTnP4vjIpTdvaHPHVrsXaNunhMxTF4pJJPRm231ZN5QeR8";
        System.out.println(api.getAuthorizationToken(authCode));
        System.out.println(api.getUserId());
    }

    @org.junit.Test
    public void testTopArtist() throws Exception {
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
        SpotDevelopDB api = new SpotDevelopDB();
        Artist[] topArtists = userDataAccessObject.getTopArtists("31kaxlo4ik6qs6vu3gtkb4i5iyye", "long_term");
        assert(Objects.equals(topArtists[0].getName(), "Paloma Faith"));
    }
}
