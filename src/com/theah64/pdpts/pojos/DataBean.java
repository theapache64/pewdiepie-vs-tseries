package com.theah64.pdpts.pojos;

public class DataBean {
    private final String id, pdpSub, tsSub, timeStamp;

    public DataBean(String id, String pdpSub, String tsSub, String timeStamp) {
        this.id = id;
        this.pdpSub = pdpSub;
        this.tsSub = tsSub;
        this.timeStamp = timeStamp;
    }

    public String getId() {
        return id;
    }

    public String getPdpSub() {
        return pdpSub;
    }

    public String getTsSub() {
        return tsSub;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}
