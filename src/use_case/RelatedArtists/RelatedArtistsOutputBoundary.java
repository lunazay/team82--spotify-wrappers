package use_case.RelatedArtists;

public interface RelatedArtistsOutputBoundary {
    void prepareSuccessView(RelatedArtistsOutputData user);
    void prepareFailView(String error);
}
