package interface_adapter.top_genre;

public class TopGenreState {
    private String id = "";
    private String idError = null;
    private String timeframe = "";
    private String timeframeError = null;

    public TopGenreState(TopGenreState copy){
        id = copy.id;
        idError = copy.idError;
        timeframe = copy.timeframe;
        timeframeError = copy.timeframeError;
    }
    public TopGenreState(){
    }
    public void setId(String id){
        this.id = id;
    }

    public void setTimeframe(String timeframe) {
        this.timeframe = timeframe;
    }

    public void setIdError(String idError) {
        this.idError = idError;
    }
    public void setTimeframeError(String timeframeError) {
        this.timeframeError = timeframeError;
    }
    public String getId(){
        return id;
    }
    public String getTimeframe() {
        return timeframe;
    }

    public String getIdError() {
        return idError;
    }
    public String getTimeframeError() {
        return timeframeError;
    }
    @Override
    public String toString(){
        return "TopGenreState{" + "id='" + id +
                '\'' + ", timeframe= '"
                + timeframe + '\'' + '}';
    }
}
