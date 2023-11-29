package interface_adapter.related_artists;


import java.util.ArrayList;
import java.util.List;

public class RelatedArtistsState {
    private List<String> relatedArtists = new ArrayList<>();
    private String error = null;
    public String timeframe;
    public String id;
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

    public void setTimeFrame(String timeFrame) {
        this.timeframe = timeFrame;
    }

    public String getTimeframe() {
        return timeframe;
    }

    public String getId() {
        return id;
    }
}
