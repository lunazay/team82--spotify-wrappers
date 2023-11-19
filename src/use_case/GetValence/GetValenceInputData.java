package use_case.GetValence;

public class GetValenceInputData {

    final private String id;

    final private String timeframe;

    public GetValenceInputData(String id, String timeframe) {
        this.id = id;
        this.timeframe = timeframe;
    }

    public String getId() { return id; }

    public String getTimeframe() { return timeframe; }
}