package use_case.TopSongs;

public class TopSongsInputData {
    private String timeframe;
    private final String id;

    public TopSongsInputData(String timeframe, String id){
        this.timeframe = timeframe;
        this.id = id;
    }

    public void setTimeframe(String timeframe) {
        this.timeframe = timeframe;
    }

    public String getTimeframe() {
        return timeframe;
    }

    public String getId(){
        return id;
    }
}
