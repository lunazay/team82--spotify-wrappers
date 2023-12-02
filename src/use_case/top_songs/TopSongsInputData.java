package use_case.top_songs;

public class TopSongsInputData {
    private String timeframe;
    private final String id;

    public TopSongsInputData(String timeframe, String id){
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
