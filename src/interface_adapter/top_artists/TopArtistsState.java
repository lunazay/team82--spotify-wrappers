package interface_adapter.top_artists;

import java.util.Collections;
import java.util.List;

public class TopArtistsState {
    private List<String> artistNames = Collections.emptyList();     // Sets default value as empty list.
    private String artistNamesError = null;

    private String timeframe = "";
    private String id;

    public TopArtistsState(TopArtistsState copy) {
        this.artistNames = copy.artistNames;
        this.artistNamesError = copy.artistNamesError;
    }

    public TopArtistsState() {}

    public void setArtistNames(List<String> artistNames) {
        this.artistNames = artistNames;
    }

    public void setArtistNamesError(String artistNamesError) {
        this.artistNamesError = artistNamesError;
    }

    public String getArtistNamesError() {
        return this.artistNamesError;
    }

    @Override
    public String toString(){
        return "TopArtistsState{" + "artistNames='" + artistNames + '}';
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
