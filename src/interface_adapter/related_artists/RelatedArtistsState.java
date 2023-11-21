package interface_adapter.related_artists;

import entity.Artist;

import java.util.List;

public class RelatedArtistsState {
    private Artist[] relatedArtists = new Artist[]{};
    private String error = null;
    public RelatedArtistsState(RelatedArtistsState copy){
        relatedArtists = copy.relatedArtists;
        error = copy.error;
    }
    public RelatedArtistsState(){};
    public Artist[] getRelatedArtists(){
        return relatedArtists;
    }
    public void setRelatedArtists(List<String> relatedArtists){
        this.relatedArtists = relatedArtists;
    }
    public void setError(String error){
        this.error = error;
    }

}
