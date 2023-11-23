package use_case.top_album;

public class TopAlbumInputData {
    private String timeframe;
    private final String id;

    public TopAlbumInputData(String timeframe, String id){
        this.timeframe = timeframe;
        this.id = id;
    }

    public void setTimeframe(String timeframe){
        this.timeframe = timeframe;
    }

    public String getTimeframe(){
        return timeframe;
    }

    public String getId(){
        return id;
    }

}
