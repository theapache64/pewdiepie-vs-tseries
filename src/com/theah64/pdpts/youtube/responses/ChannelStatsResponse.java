package com.theah64.pdpts.youtube.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChannelStatsResponse {

    @SerializedName("kind")
    private final String kind;

    @SerializedName("etag")
    private final String etag;

    @SerializedName("items")
    private final List<Item> items;

    @SerializedName("pageInfo")
    private final PageInfo pageinfo;


    public ChannelStatsResponse(String kind, String etag, List<Item> items, PageInfo pageinfo) {
        this.kind = kind;
        this.etag = etag;
        this.items = items;
        this.pageinfo = pageinfo;
    }

    public String getKind() {
        return kind;
    }

    public String getEtag() {
        return etag;
    }

    public List<Item> getItems() {
        return items;
    }

    public PageInfo getPageinfo() {
        return pageinfo;
    }

    @Override
    public String toString() {
        return "ChannelStatsResponse{" +
                "kind='" + kind + '\'' +
                ", etag='" + etag + '\'' +
                ", items=" + items +
                ", pageinfo=" + pageinfo +
                '}';
    }

    public static class Item {

        @SerializedName("id")
        private final String id;

        @SerializedName("kind")
        private final String kind;

        @SerializedName("etag")
        private final String etag;

        @SerializedName("statistics")
        private final Statistics statistics;


        public Item(String id, String kind, String etag, Statistics statistics) {
            this.id = id;
            this.kind = kind;
            this.etag = etag;
            this.statistics = statistics;
        }

        public String getId() {
            return id;
        }

        public String getKind() {
            return kind;
        }

        public String getEtag() {
            return etag;
        }

        public Statistics getStatistics() {
            return statistics;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "id='" + id + '\'' +
                    ", kind='" + kind + '\'' +
                    ", etag='" + etag + '\'' +
                    ", statistics=" + statistics +
                    '}';
        }
    }

    public static class Statistics {

        @SerializedName("viewCount")
        private final String viewcount;

        @SerializedName("videoCount")
        private final String videocount;

        @SerializedName("commentCount")
        private final String commentcount;

        @SerializedName("subscriberCount")
        private final String subscribercount;

        @SerializedName("hiddenSubscriberCount")
        private final boolean hiddensubscribercount;


        public Statistics(String viewcount, String videocount, String commentcount, String subscribercount, boolean hiddensubscribercount) {
            this.viewcount = viewcount;
            this.videocount = videocount;
            this.commentcount = commentcount;
            this.subscribercount = subscribercount;
            this.hiddensubscribercount = hiddensubscribercount;
        }

        public String getViewcount() {
            return viewcount;
        }

        public String getVideocount() {
            return videocount;
        }

        public String getCommentcount() {
            return commentcount;
        }

        public String getSubscribercount() {
            return subscribercount;
        }

        public boolean isHiddensubscribercount() {
            return hiddensubscribercount;
        }

        @Override
        public String toString() {
            return "Statistics{" +
                    "viewcount='" + viewcount + '\'' +
                    ", videocount='" + videocount + '\'' +
                    ", commentcount='" + commentcount + '\'' +
                    ", subscribercount='" + subscribercount + '\'' +
                    ", hiddensubscribercount=" + hiddensubscribercount +
                    '}';
        }
    }

    public static class PageInfo {

        @SerializedName("totalResults")
        private final int totalresults;

        @SerializedName("resultsPerPage")
        private final int resultsperpage;


        public PageInfo(int totalresults, int resultsperpage) {
            this.totalresults = totalresults;
            this.resultsperpage = resultsperpage;
        }

        public int getTotalresults() {
            return totalresults;
        }

        public int getResultsperpage() {
            return resultsperpage;
        }

        @Override
        public String toString() {
            return "PageInfo{" +
                    "totalresults=" + totalresults +
                    ", resultsperpage=" + resultsperpage +
                    '}';
        }
    }

}
