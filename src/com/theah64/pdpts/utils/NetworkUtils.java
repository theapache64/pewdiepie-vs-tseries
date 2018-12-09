package com.theah64.pdpts.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtils {
    /**
     * To process a GET request and return the response from the given URL
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String get(String url) throws IOException {
        final URL urlObj = new URL(url);
        final HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
        final BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        final StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
