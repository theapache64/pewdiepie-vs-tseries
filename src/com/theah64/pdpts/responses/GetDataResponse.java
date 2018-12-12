package com.theah64.pdpts.responses;

import com.google.gson.annotations.SerializedName;


/**
 * Generated using MockAPI (https://github.com/theapache64/Mock-API) : Sun Dec 09 17:59:41 UTC 2018
 */
public class GetDataResponse {

    @SerializedName("t_series")
    private final String tSeries;

    @SerializedName("pew_die_pie")
    private final String pewDiePie;

    @SerializedName("analysis")
    private final Analysis analysis;


    public GetDataResponse(String tSeries, String pewDiePie, Analysis analysis) {
        this.tSeries = tSeries;
        this.pewDiePie = pewDiePie;
        this.analysis = analysis;
    }


    public static class Analysis {

        @SerializedName("lead")
        private final String lead;

        @SerializedName("difference")
        private final String difference;

        public Analysis(String lead, String difference) {
            this.lead = lead;
            this.difference = difference;
        }

        public String getLead() {
            return lead;
        }

        public String getDifference() {
            return difference;
        }
    }
}