package use_case.RelatedArtists;

import java.util.List;

public class RelatedArtistsOutputData {
    private List<String> relatedArtists;
    private boolean useCaseFailed;
    public RelatedArtistsOutputData(List<String> relatedArtists, boolean useCaseFailed){
        this.relatedArtists = relatedArtists;
        this.useCaseFailed = useCaseFailed;
    }
    public List<String> getRelatedArtists(){
        return relatedArtists;
    }
}
