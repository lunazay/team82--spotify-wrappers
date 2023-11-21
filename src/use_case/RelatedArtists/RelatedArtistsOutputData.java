package use_case.RelatedArtists;

import entity.Artist;

import java.util.List;

public class RelatedArtistsOutputData {
    private Artist[] relatedArtists;
    private boolean useCaseFailed;
    public RelatedArtistsOutputData(List<String> relatedArtists, boolean useCaseFailed){
        this.relatedArtists = relatedArtists;
        this.useCaseFailed = useCaseFailed;
    }
    public Artist[] getRelatedArtists(){
        return relatedArtists;
    }
}
