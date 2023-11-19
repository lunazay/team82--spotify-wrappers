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
import java.util.ArrayList;
import java.util.Base64;
import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

public class SpotDevelopDB implements DevelopDB{

    String client_id = "bad90b33466e4f208c7655eede3ac628";
    String client_secret = "15abfd5161e84bfe893606e4eb74f5f6";
    String redirect_uri = "https://oauth.pstmn.io/v1/browser-callback";
    String authToken; // TODO: figure out where we should store the authorization token!


    @Override
    public String getAuthorizationLink() throws MalformedURLException {

        return "https://accounts.spotify.com/authorize?"
                + "client_id="+client_id+"&"
                + "response_type=code&"
                + "redirect_uri="+redirect_uri+"&"
                + "scope=user-read-private%20user-read-email%user-top-read%playlist-modify-public%playlist-modify-private&";
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
    public String get_valence(String songId) throws IOException {

        // TODO: change this to get the valence for one song, and have the data access object
        // TODO: just call this a bunch of times. (Instead of doing it all in one big call.)

        String request = "https://api.spotify.com/v1/audio-features/" + songId;

        URL request_url = new URL(request);

        HttpURLConnection conn = (HttpURLConnection) request_url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        if (conn.getResponseMessage().equals("OK")) {

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                response.append("\n");
            }
            in.close();

            String[] arrayResponse = response.toString().split("[: ,]");

            return arrayResponse[arrayResponse.length - 1];
        }

        return null;
    }

    @Override
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public User getTopSongs(String time_frame, int numSongs) throws JSONException{
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        String url = "https://api.spotify.com/v1/me/top/tracks?" + "time_range=" + time_frame + "&limit=" + numSongs;
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject requestBody = new JSONObject();
        requestBody.get("tracks");
        RequestBody body = RequestBody.create(mediaType, requestBody.toString());
        // i dont know what the above line does or why it is deprecated
        Request request = new Request.Builder()
                .url(url)
                .method("GET", body)
                .addHeader("Authorization", authToken)
                .addHeader("Content-Type", "application/json")
                .build();
        try{
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());
            if (responseBody.getInt("status_code") == 200) {
                return null;
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getTopArtists(String time_frame) throws JSONException{
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        String url = "https://api.spotify.com/v1/me/top/artists?" + "time_range=" + time_frame;
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject requestBody = new JSONObject();
        requestBody.get("artists");
        RequestBody body = RequestBody.create(mediaType, requestBody.toString());
        Request request = new Request.Builder()
                .url(url)
                .method("GET", body)
                .addHeader("Authorization", authToken)
                .addHeader("Content-Type", "application/json")
                .build();
        try{
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());
            if (responseBody.getInt("status_code") == 200) {
                return null;
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getRelatedArtists(String topArtistID) throws JSONException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        String url = "https://api.spotify.com/v1/artists/" + topArtistID + "/related-artists";
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject requestBody = new JSONObject();
        requestBody.get("related artists");
        RequestBody body = RequestBody.create(mediaType, requestBody.toString());
        Request request = new Request.Builder()
                .url(url)
                .method("GET", body)
                .addHeader("Authorization", authToken)
                .addHeader("Content-Type", "application/json")
                .build();
        try{
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());
            if (responseBody.getInt("status_code") == 200) {
                return null;
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}