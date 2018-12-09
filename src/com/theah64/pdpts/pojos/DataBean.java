package com.theah64.pdpts.pojos;

import java.math.BigInteger;

public class DataBean {
    private final String id;
    private final BigInteger pdpSub;
    private final BigInteger tsSub;
    private final BigInteger timeStamp;

    public DataBean(String id, BigInteger pdpSub, BigInteger tsSub, BigInteger timeStamp) {
        this.id = id;
        this.pdpSub = pdpSub;
        this.tsSub = tsSub;
        this.timeStamp = timeStamp;
    }

    public String getId() {
        return id;
    }

    public BigInteger getPdpSub() {
        return pdpSub;
    }

    public BigInteger getTsSub() {
        return tsSub;
    }

    public BigInteger getTimeStamp() {
        return timeStamp;
    }
}
