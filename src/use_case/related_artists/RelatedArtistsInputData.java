package use_case.related_artists;

public class RelatedArtistsInputData {
    private String timeframe;
    private final String id;

    public RelatedArtistsInputData(String timeframe, String id){
        this.timeframe = timeframe;
        this.id = id;
    }

    public String getTimeframe(){return timeframe;}

    public String getId() {return id;}
}
