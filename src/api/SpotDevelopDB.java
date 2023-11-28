package api;

import entity.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
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

    // instead of calling using authToken use token() method!

    private String token() throws IOException {
        File txtFile = new File("./supersecret.txt");

        // writing the token to the file:
        BufferedReader reader = new BufferedReader(new FileReader(txtFile));
        return reader.readLine();
    }

    @Override
    public String getUserId() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        String url = "https://api.spotify.com/v1/me";
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject requestBody = new JSONObject();
        requestBody.get("");
        RequestBody body = RequestBody.create(mediaType, requestBody.toString());
        Request request = new Request.Builder()
                .url(url)
                .method("GET", body)
                .addHeader("Authorization", token())
                .build();
        try{
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());
            if (responseBody.getInt("status_code") == 200) {
                return responseBody.getString("id");
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
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

            String[] arrayResponse = response.toString().split("[: ,]");

            // trimming the " characters that are at the beginning and end of the string
            return arrayResponse[1].substring(1, arrayResponse[1].length() - 1);


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
            System.out.println(conn.getResponseCode());
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
                System.out.println(responseBody);

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
        /*OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        String url = "https://api.spotify.com/v1/me/top/tracks?" + "time_range=" + timeframe + "&limit=" + numSongs;
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject requestBody = new JSONObject();
        requestBody.get("tracks");
        RequestBody body = RequestBody.create(mediaType, requestBody.toString());
        // i dont know what the above line does or why it is deprecated
        Request request = new Request.Builder()
                .url(url)
                .method("GET", body)
                .addHeader("Authorization", token())
                .addHeader("Content-Type", "application/json")
                .build();
        try{
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());
            if (responseBody.getInt("status_code") == 200) {
                return SongFactory.create(responseBody);
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }*/
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/me/top/artists")
                .method("GET", null)
                .build();
        try{
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());
            return SongFactory.create(responseBody);
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Artist[] getTopArtists(String timeframe) throws JSONException, IOException {
        /*String request = "https://api.spotify.com/v1/me/top/artists";
        try {
            URL request_url = new URL(request);
            HttpURLConnection conn = (HttpURLConnection) request_url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + token());
            conn.connect();

            if (conn.getResponseCode() == (200)){
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while
            }
        }*/
        /*OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        String url = "https://api.spotify.com/v1/me/top/artists?" + "time_range=" + timeframe;
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject requestBody = new JSONObject();
        RequestBody body = RequestBody.create(mediaType, requestBody.toString());
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .addHeader("Authorization", token())
                .addHeader("Content-Type", "application/json")
                .build();
        try{
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());
            if (responseBody.getInt("status_code") == 200) {
                return ArtistFactory.create(responseBody);
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }*/
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/me/top/artists")
                .method("GET", null)
                .build();
        try{
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());
            return ArtistFactory.create(responseBody);
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    }