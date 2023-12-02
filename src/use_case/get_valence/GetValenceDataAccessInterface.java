package use_case.get_valence;


public interface GetValenceDataAccessInterface {

    String getValence(String id, String timeframe) throws Exception;
}
