package interface_adapter.related_artists;


import java.util.ArrayList;
import java.util.List;

public class RelatedArtistsState {
    public List<String> relatedArtists = new ArrayList<>();
    private String error = null;
    public RelatedArtistsState(RelatedArtistsState copy){
        relatedArtists = copy.relatedArtists;
        error = copy.error;
    }
    public RelatedArtistsState(){};
    public List<String> getRelatedArtists(){
        return relatedArtists;
    }
    public void setRelatedArtists(List<String> relatedArtists){
        this.relatedArtists = relatedArtists;
    }
    public void setError(String error){
        this.error = error;
    }

}
