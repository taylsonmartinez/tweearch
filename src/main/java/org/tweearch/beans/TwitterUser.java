package org.tweearch.beans;

/**
 * User: Angelo Albiero Neto
 * Date: 1/31/12
 * Time: 6:16 PM
 */
public class TwitterUser {

    private Long userId;
    private String username;
    private String name;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
