package api;

import entity.User;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class SpotDevelopDB implements DevelopDB{

    String client_id = "bad90b33466e4f208c7655eede3ac628";
    String client_secret = "15abfd5161e84bfe893606e4eb74f5f6";
    String redirect_uri = "https://oauth.pstmn.io/v1/browser-callback";
    String authToken;

    @Override
    public User getTopArtist() {
        return null;
    }

    @Override
    public String getAuthorizationLink() throws MalformedURLException {

        return "https://accounts.spotify.com/authorize?"
                              + "client_id="+client_id+"&"
                              + "response_type=code&"
                              + "redirect_uri="+redirect_uri+"&"
                              + "scope=user-read-private%20user-read-email&";
    }

    @Override
    public String getAuthorizationToken(String authCode) throws IOException {

        String auth_string = "https://accounts.spotify.com/api/token";
        URL auth_url = new URL(auth_string);


        String post_data = "grant_type=authorization_code&" +
                           "code=" + authCode + "&" +
                           "redirect_uri=" + "https%3A%2F%2Foauth.pstmn.io%2Fv1%2Fbrowser-callback";


        byte[] postData = post_data.getBytes(StandardCharsets.UTF_8);

        int length = postData.length;

        HttpURLConnection conn = (HttpURLConnection) auth_url.openConnection();
        conn.setRequestMethod("POST");
        conn.setFixedLengthStreamingMode(length);

        String to_encode = client_id +":"+client_secret;

        String encoded_auth = "Basic " + Base64.getEncoder().encodeToString(to_encode.getBytes());

        conn.setRequestProperty("Authorization", encoded_auth);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        conn.setDoOutput(true);
        conn.connect();

        try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
            wr.write(postData);
        }

        int responseCode = conn.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String[] arrayResponse = response.toString().split("[: ,]");

            // trimming the " characters that are at the beginning and end of the string
            return arrayResponse[1].substring(1, arrayResponse[1].length() - 1);


        }
        return null;
    }

    @Override
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public User getTopSongs() {
        return null;
    }

}