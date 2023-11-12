package use_case.TopSongs;
import entity.User;

public class TopSongsInputData {
    private String timeframe;

    public TopSongsInputData(String timeframe){
        this.timeframe = timeframe;
    }

    public void setTimeframe(String timeframe) {
        this.timeframe = timeframe;
    }

    public String getTimeframe() {
        return timeframe;
    }
}
