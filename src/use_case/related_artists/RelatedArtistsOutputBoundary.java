package use_case.related_artists;

public interface RelatedArtistsOutputBoundary {
    void prepareSuccessView(RelatedArtistsOutputData user);
    void prepareFailView(String error);
}
