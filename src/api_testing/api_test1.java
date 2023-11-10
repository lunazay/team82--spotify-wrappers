package api_testing;

import entity.Artist;
import entity.DataObject;
import entity.Song;
import entity.User;
import okhttp3.*;

import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;


public class api_test1 {

    private static final String client_id = "bad90b33466e4f208c7655eede3ac628";
    private static final String client_secret = "15abfd5161e84bfe893606e4eb74f5f6";

    private static String redirect_uri = "https://oauth.pstmn.io/v1/browser-callback";

    public static Object get_token() throws IOException {
        String auth_code = "AQClMwynzxFjVytTTWiFR5jwLjv7ypFWv1ownYFASrtO6DMSAWRrAb2clcn2WomtfxC2i__egU4SiELeT0VhZXyE7fy1sT8ftIVZKSNn1o449oq73_HKWPx0wH1EWpXx6BTNwenWLN7VhKdHH4YOjLyPoisppwtAjv4UScNCcJjni6F-yQUQspUE_A7yKyLdLpxRFIAhA_Ws_cDsACbbc8q0rddQM_pm4f3lqo2cNh2gqQ";
        String auth_string = "https://accounts.spotify.com/api/token";
        URL auth_url = new URL(auth_string);


        String post_data = "grant_type=authorization_code&" +
                           "code=" + auth_code + "&" +
                           "redirect_uri=" + "https%3A%2F%2Foauth.pstmn.io%2Fv1%2Fbrowser-callback"
                           ;

        byte[] postData = post_data.getBytes(StandardCharsets.UTF_8);
        // for (Object i : postData) {System.out.println(i);}

        int length = postData.length;

        HttpURLConnection conn = (HttpURLConnection) auth_url.openConnection();
        conn.setRequestMethod("POST");
        conn.setFixedLengthStreamingMode(length);

        String to_encode = client_id +":"+client_secret;

        String encoded_auth = "Basic " + Base64.getEncoder().encodeToString(to_encode.getBytes());

        //String encoded_auth = "Basic " + Base64.getEncoder().encodeToString(client_id.getBytes()) + ":" +
        //        Base64.getEncoder().encodeToString(client_secret.getBytes());
        conn.setRequestProperty("Authorization", encoded_auth);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        conn.setDoOutput(true);
        conn.connect();

        try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
            wr.write(postData);
        }

        int responseCode = conn.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());


        }
        return null;
    }


    public static Object get_code() throws MalformedURLException {
        try {
            //URL auth_url = new URL("https://api.spotify.com/authorize");
            String auth_string =
                    "https://accounts.spotify.com/authorize?"
                            + "client_id="+client_id+"&"
                            + "response_type=code&"
                            + "redirect_uri="+redirect_uri+"&"
                            + "scope=user-read-private%20user-read-email&";

            System.out.println(auth_string);
            URL auth_url = new URL(auth_string);

            HttpURLConnection conn = (HttpURLConnection) auth_url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            conn.setInstanceFollowRedirects(true);  //you still need to handle redirect manully.
            HttpURLConnection.setFollowRedirects(true);

            Desktop desktop = Desktop.getDesktop();
            desktop.browse(auth_url.toURI());


            if (conn.getResponseMessage().equals("OK")) {

                String code = conn.getHeaderField(3);

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                    response.append("\n");
                }
                in.close();

                // print result
                System.out.println(conn);
                System.out.println(code);
                System.out.println(response.toString());
            }

            conn.disconnect();
            conn.getInputStream();

            
        } catch (MalformedURLException e) {
            throw new MalformedURLException();
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // for pkce if we need it
    private String generateRandomString(int length) {

        StringBuilder codeVerifier = new StringBuilder();
        String possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();

        while (codeVerifier.length() < length) {
            int index = random.nextInt();
            codeVerifier.append(possible.charAt(index));
        }

        return codeVerifier.toString();
    }

    private byte[] hash (String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashed = digest.digest(
                input.getBytes(StandardCharsets.UTF_8));

        return hashed;
    }

    private String getCodeVerifier() throws NoSuchAlgorithmException {
        String c = generateRandomString(64);
        return Base64.getEncoder().encodeToString(hash(c));
    }

    public static void main(String[] args) throws IOException {
        get_code();
    }
}