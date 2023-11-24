package use_case.top_album;

public interface TopAlbumOutputBoundary {
    /**
     * Updates the view with the list of TopArtists received.
     *
     * @param user Stores the list of the names of the user's top artists.
     */
    void prepareSuccessView(TopAlbumOutputData user);

    /**
     * Updates the view with an error to be displayed.
     *
     * @param error The error to show to the user
     */
    void prepareFailView(String error);
}
