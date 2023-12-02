package interface_adapter.related_artists;


import java.util.ArrayList;
import java.util.List;

public class RelatedArtistsState {
    public List<String> relatedArtists = new ArrayList<>();
    private String relatedArtistsError = null;

    public RelatedArtistsState(){}
    public List<String> getRelatedArtists(){
        return relatedArtists;
    }
    public void setRelatedArtists(List<String> relatedArtists){
        this.relatedArtists = relatedArtists;
    }
    public void setRelatedArtistsError(String error){
        this.relatedArtistsError = error;
    }
    public String getRelatedArtistsError() {
        return this.relatedArtistsError;
    }
}
