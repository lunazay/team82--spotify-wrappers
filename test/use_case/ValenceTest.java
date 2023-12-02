package use_case;

import api.SpotDevelopDB;
import data_access.UserDataAccessObject;

import java.util.Objects;

/**
 * This class contains tests for the Valence use case.
 */

public class ValenceTest {
    public static void main(String[] args) throws Exception{
        SpotDevelopDB api = new SpotDevelopDB();
        System.out.println(api.getAuthorizationToken("AQCsprw9Wm5vE6Vznq42FQM3qb0zLSW2Qqx76ezx2Ykl7NFZUfSMIyfNFgb_OrOsYmbu84iHwPnI-uyzbV8LH0KUgWlkeKfOuBKRNZKZxYiITPlob1gm6NV__SvgLLovajQhd4VEZ2ixwPiQESuctYHXJ-M28FSPYn5hSqnYOl-bVq6_Nc5Hgf15qTAIIRN1gQDZZwfTBE2Oj9y1ANEhrJd44pppwc_11-wjzp49bJ877mPQB67s7cJ2uH_ar_5XgXXkXCmGBIPTHZ8ZcxI9-JJSuN5cwtNKZkcs089bUKFyEYQEgLTPgQZLUlln_qDMdr4"));
    }

    /**
     * Retrieves the top genres for a user.
     *
     * @return List of strings of top artist's related artists.
     * @throws Exception If an error occurs during data retrieval.
     */
    public String getValence() throws Exception{
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
        String valence = userDataAccessObject.getValence("luna987654321", "short_term");
        return valence;
    }

    @org.junit.Test
    public void testAPIGetRelatedArtists() throws Exception{
        String valence = getValence();
        assert(Objects.equals(valence, "0.39005499999999993"));
    }
}
