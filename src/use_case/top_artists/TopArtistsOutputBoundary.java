package use_case.top_artists;

public interface TopArtistsOutputBoundary {

    /**
     * Updates the view with the list of TopArtists received.
     *
     * @param artists Stores the list of the names of the user's top artists.
     */
    void prepareSuccessView(TopArtistsOutputData artists);

    /**
     * Updates the view with an error to be displayed.
     *
     * @param error The error to show to the user
     */
    void prepareFailView(String error);
}
