package use_case.RelatedArtist;

public class RelatedArtistInputData {
    private String timeframe;
    private final String id;

    public RelatedArtistInputData(String timeframe, String id){
        this.timeframe = timeframe;
        this.id = id;
    }
    public void setTimeframe(String timeframe){this.timeframe = timeframe;}
    public String getTimeframe(){return timeframe;}

    public String getId() {return id;}
}
