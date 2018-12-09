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


    public GetDataResponse(String tSeries, String pewDiePie) {
        this.tSeries = tSeries;
        this.pewDiePie = pewDiePie;
    }

    public String getTSeries() {
        return tSeries;
    }

    public String getPewDiePie() {
        return pewDiePie;
    }


}