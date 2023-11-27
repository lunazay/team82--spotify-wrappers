package use_case.related_artists;

public interface RelatedArtistsOutputBoundary {

    /**
     * Updates the view with the list of RelatedArtists received.
     *
     * @param artists Stores the list of the names of the top artist's artists.
     */
    void prepareSuccessView(RelatedArtistsOutputData artists);
    /**
     * Updates the view with an error to be displayed.
     *
     * @param error The error to show to the user
     */
    void prepareFailView(String error);
}
