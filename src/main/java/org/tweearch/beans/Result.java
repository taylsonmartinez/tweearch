package org.tweearch.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Angelo Albiero Neto
 * Date: 1/31/12
 * Time: 5:16 PM
 */
public class Result {

    private Long maxId;

    private Integer page;

    private Integer rpp;

    private Long sinceId;

    private List<Tweet> tweets;

    public Long getMaxId() {
        return maxId;
    }

    public void setMaxId(Long maxId) {
        this.maxId = maxId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRpp() {
        return rpp;
    }

    public void setRpp(Integer rpp) {
        this.rpp = rpp;
    }

    public Long getSinceId() {
        return sinceId;
    }

    public void setSinceId(Long sinceId) {
        this.sinceId = sinceId;
    }

    public List<Tweet> getTweets() {
        if (this.tweets == null)
            this.tweets = new ArrayList<Tweet>();
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }
}
