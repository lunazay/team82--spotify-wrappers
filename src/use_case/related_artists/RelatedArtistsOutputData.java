package use_case.related_artists;

import java.util.List;

public class RelatedArtistsOutputData {
    private final List<String> relatedArtists;
    private final boolean useCaseFailed;
    public RelatedArtistsOutputData(List<String> relatedArtists, boolean useCaseFailed){
        this.relatedArtists = relatedArtists;
        this.useCaseFailed = useCaseFailed;
    }
    public List<String> getRelatedArtists(){
        return relatedArtists;
    }
}
