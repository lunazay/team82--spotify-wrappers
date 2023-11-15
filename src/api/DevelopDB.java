package api;

import entity.User;
import entity.Artist;
import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;

public interface DevelopDB {
    String client_id = "bad90b33466e4f208c7655eede3ac628";
    String client_secret = "15abfd5161e84bfe893606e4eb74f5f6";
    String redirect_uri = "https://oauth.pstmn.io/v1/browser-callback";
    User getTopSongs();

    User getTopArtist();

    String getAuthorizationLink() throws MalformedURLException;

    String getAuthorizationToken(String authCode) throws IOException;


}
