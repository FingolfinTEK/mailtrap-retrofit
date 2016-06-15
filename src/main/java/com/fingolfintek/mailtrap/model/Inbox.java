package com.fingolfintek.mailtrap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Inbox {

    private String id;
    private String name;
    private String domain;
    private String username;
    private String password;
    private String emailDomain;
    private int maxSize;
    private int emailsCount;
    private int emailsUnreadCount;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDomain() {
        return domain;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailDomain() {
        return emailDomain;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getEmailsCount() {
        return emailsCount;
    }

    public int getEmailsUnreadCount() {
        return emailsUnreadCount;
    }

    @Override
    public String toString() {
        return "Inbox{" + "id='" + id +
                ", name='" + name +
                ", domain='" + domain +
                ", username='" + username +
                ", password='" + password +
                ", emailDomain='" + emailDomain +
                ", maxSize=" + maxSize +
                ", emailsCount=" + emailsCount +
                ", emailsUnreadCount=" + emailsUnreadCount +
                '}';
    }
}
