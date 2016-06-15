package com.fingolfintek.mailtrap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

    private String id;
    private String inboxId;
    private String subject;
    private String fromEmail;
    private String fromName;
    private String toEmail;
    private String toName;
    private String htmlBody;
    private String textBody;
    private long emailSize;
    private String humanSize;

    public String getId() {
        return id;
    }

    public String getInboxId() {
        return inboxId;
    }

    public String getSubject() {
        return subject;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public String getFromName() {
        return fromName;
    }

    public String getToEmail() {
        return toEmail;
    }

    public String getToName() {
        return toName;
    }

    public String getHtmlBody() {
        return htmlBody;
    }

    public String getTextBody() {
        return textBody;
    }

    public long getEmailSize() {
        return emailSize;
    }

    public String getHumanSize() {
        return humanSize;
    }

    @Override
    public String toString() {
        return "Message{id='" + id +
                ", inboxId='" + inboxId +
                ", subject='" + subject +
                ", fromEmail='" + fromEmail +
                ", fromName='" + fromName +
                ", toEmail='" + toEmail +
                ", toName='" + toName +
                ", htmlBody='" + htmlBody +
                ", textBody='" + textBody +
                ", emailSize=" + emailSize +
                ", humanSize='" + humanSize +
                '}';
    }
}
