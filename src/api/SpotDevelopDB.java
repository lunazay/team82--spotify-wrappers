package api;

import entity.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

public class SpotDevelopDB implements DevelopDB{

    String client_id = "bad90b33466e4f208c7655eede3ac628";
    String client_secret = "15abfd5161e84bfe893606e4eb74f5f6";
    String redirect_uri = "https://oauth.pstmn.io/v1/browser-callback";

    // instead of calling using authToken use token() method!

    public String token() throws IOException { // TODO: change this back to private when done testing.
        File txtFile = new File("./supersecret.txt");

        // writing the token to the file:
        BufferedReader reader = new BufferedReader(new FileReader(txtFile));
        return reader.readLine();
    }

    @Override
    public String getUserId() throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = "https://api.spotify.com/v1/me";
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("Authorization", "Bearer " + token())
                .build();
        try (Response response = client.newCall(request).execute()){
            if (!response.isSuccessful()){
                throw new IOException("Unexpected code " + response);
            }
            String responseBody = response.body().string();
            JSONObject jsonObject = new JSONObject(responseBody);
            return jsonObject.getString("id");
        } catch (JSONException e){
            throw new IOException("Error parsing JSON response", e);
        }

    }

    @Override
    public JSONObject getRelatedArtists(String topArtistID) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/artists/" + topArtistID + "/related-artists")
                .get()
                .addHeader("Authorization", "Bearer " + token())
                .build();
        try{
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()){
                throw new IOException("Unexpected code " + response);
            }

            JSONObject responseBody = new JSONObject(response.body().string());
            System.out.println(responseBody);
            return responseBody;
        }catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getAuthorizationLink() throws MalformedURLException {

        return "https://accounts.spotify.com/authorize?"
                + "client_id="+client_id+"&"
                + "response_type=code&"
                + "redirect_uri="+redirect_uri+"&"
                + "scope=user-read-private%20user-read-email%20user-top-read%20playlist-modify-public%20playlist-modify-private&";
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

            JSONObject responseBody = new JSONObject(response.toString());
            return responseBody.get("access_token").toString();


        }
        return null;
    }

    @Override
    public String get_valence(String songId) throws IOException {

        String request = "https://api.spotify.com/v1/audio-features/" + songId;
        try {
            URL request_url = new URL(request);

            HttpURLConnection conn = (HttpURLConnection) request_url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + token());
            conn.connect();
            if (conn.getResponseCode() == (200)) {

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                    response.append("\n");
                }
                in.close();

                JSONObject responseBody = new JSONObject(response.toString());
                return responseBody.get("valence").toString();
            }
            return conn.getResponseMessage();
        } catch (MalformedURLException e) {
            throw new MalformedURLException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Song[] getTopSongs(String timeframe, int numSongs) throws JSONException, IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/me/top/tracks?" + "time_range=" + timeframe)
                .get()
                .addHeader("Authorization", "Bearer " + token())
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            JSONObject responseBody = new JSONObject(response.body().string());
            System.out.println(responseBody);
            return SongFactory.create(responseBody);
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Artist[] getTopArtists(String timeframe) throws JSONException, IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/me/top/artists?" + "time_range=" + timeframe)
                .get()
                .addHeader("Authorization", "Bearer " + token())
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            JSONObject responseBody = new JSONObject(response.body().string());
            System.out.println(responseBody);
            return ArtistFactory.create(responseBody);
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}