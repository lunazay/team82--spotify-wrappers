package use_case.top_artists;

public class TopArtistsInputData {
    private String timeframe;
    private final String id;

    public TopArtistsInputData(String timeframe, String id){
        this.timeframe = timeframe;
        this.id = id;
    }

    public String getTimeframe() {
        return timeframe;
    }

    public String getId(){
        return id;
    }
}
