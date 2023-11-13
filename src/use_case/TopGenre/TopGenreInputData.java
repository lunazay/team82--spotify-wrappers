package use_case.TopGenre;

public class TopGenreInputData {
    private final String timeframe;
    private final String id;

    public TopGenreInputData(String timeframe, String id){
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
