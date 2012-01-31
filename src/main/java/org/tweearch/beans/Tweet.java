package org.tweearch.beans;

import java.util.Calendar;

/**
 * User: Angelo Albiero Neto
 * Date: 1/31/12
 * Time: 6:20 PM
 */
public class Tweet {

    private Long id;

    private Calendar createdAt;

    private String language;

    private String profileURL;

    private String text;

    private TwitterUser fromUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getProfileURL() {
        return profileURL;
    }

    public void setProfileURL(String profileURL) {
        this.profileURL = profileURL;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TwitterUser getFromUser() {
        return fromUser;
    }

    public void setFromUser(TwitterUser fromUser) {
        this.fromUser = fromUser;
    }
}
