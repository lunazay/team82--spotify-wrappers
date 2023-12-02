package use_case;

import api.SpotDevelopDB;
import data_access.UserDataAccessObject;
import entity.Album;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static org.junit.Assert.*;

/**
 * This class contains tests for the TopAlbum use case.
 */

public class TopAlbumTest {

    String id = "baller4life7579";

    // change this value accordingly based on term to test
    String timeframe = "medium_term";

    /**
     * The main method to execute the test.
     *
     * @param args Command-line arguments.
     * @throws IOException If an I/O error occurs.
     */
    public static void main(String[] args) throws IOException {

        SpotDevelopDB api = new SpotDevelopDB();
        String myAuthCode = "AQDmqVFpz_u4r5LFlrvPFZxYKPDqHOcNV9sd7TTr15bZINmvqpAtz22z0hrLzH285bK0sjSuNNFQrV-tojOmOEvsJjyezEz7c9mOkRPGQd6no4gXa_89F9xUoAxyxYanNj27Iuqg4R-Ae2C6xZFkQrWBFA2PUM0B_C36WMSf9ux_zzbheIw9AiDoH6Rt7Rk4_qNReFukTIn9KcDgpKYjceNKHqMRW3ddqJjI0vdw5LfAbXcq7I3k7PbdH6R4oihmrhE-Duu2KgJo-02JuKq9EXW_fOT_imglmL8ZI77FRS-tb_6gSzbWZW-I7PpnS2vJ7PU";
        System.out.println(api.getAuthorizationToken(myAuthCode));

    }

    /**
     * Retrieves the top albums for a user.
     *
     * @return ArrayList of top albums.
     * @throws Exception If an error occurs during data retrieval.
     */
    public ArrayList<Album> getTopAlbums() throws Exception {

        UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
        ArrayList<Album> topAlbums = userDataAccessObject.getTopAlbums(id, timeframe);
        return topAlbums;

    }

    /**
     * Test method for the getTopAlbums function.
     * Asserts the correct top album is outputted in the given term
     *
     * @throws Exception If an error occurs during the test.
     */
    @org.junit.Test
    public void testTopAlbum() throws Exception {

        ArrayList<Album> topAlbums = getTopAlbums();
        if (timeframe.equals("long_term")) {
            assert (Objects.equals(topAlbums.get(0).getName(), "Serithaana"));
        } else if (timeframe.equals("medium_term")) {
            assert (Objects.equals(topAlbums.get(0).getName(), "The World Is Yours"));
        }
        assert (Objects.equals(topAlbums.get(0).getName(), "The World Is Yours"));

    }

    /**
     * Test method for the getTopAlbums function.
     * Asserts 20 top albums are outputted
     *
     * @throws Exception If an error occurs during the test.
     */
    @org.junit.Test
    public void testTopTwentyAlbums() throws Exception {
        ArrayList<Album> topAlbums = getTopAlbums();
        assert(topAlbums.size() == 20);
    }



}


