package com.theah64.pdpts.youtube;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.theah64.pdpts.utils.NetworkUtils;
import com.theah64.pdpts.youtube.responses.ChannelStatsResponse;

import java.io.IOException;

public class YouTubeAPI {

    private static final String API_KEY = "AIzaSyCa44yDC3PeReSqpW0kJj38IdipWCjqea4";
    private static final String STATISTICS_URL_FORMAT = "https://www.googleapis.com/youtube/v3/channels?part=statistics&id={CHANNEL_ID}&key=" + API_KEY;

    private static final Gson GSON = new GsonBuilder()
            .create();

    public static ChannelStatsResponse getStatistics(String channelId) throws IOException {

        // Getting network response
        final String response = NetworkUtils.get(getStatisticsUrl(channelId));
        final ChannelStatsResponse channelStatsResponse = convertToChannelStats(response);
        return channelStatsResponse;
    }

    private static ChannelStatsResponse convertToChannelStats(String response) {
        return GSON.fromJson(response, ChannelStatsResponse.class);
    }

    private static String getStatisticsUrl(String channelId) {
        return STATISTICS_URL_FORMAT.replace("{CHANNEL_ID}", channelId);
    }
}
