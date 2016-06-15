package com.fingolfintek.mailtrap.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attachment {

    private String id;
    private String messageId;
    private String filename;
    private String attachmentType;
    private String contentId;
    private String transferEncoding;
    private String downloadPath;
    private long attachmentSize;
    private String attachmentHumanSize;

    public String getId() {
        return id;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getFilename() {
        return filename;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public String getContentId() {
        return contentId;
    }

    public String getTransferEncoding() {
        return transferEncoding;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public long getAttachmentSize() {
        return attachmentSize;
    }

    public String getAttachmentHumanSize() {
        return attachmentHumanSize;
    }

    @Override
    public String toString() {
        return "Attachment{" + "id='" + id +
                ", messageId='" + messageId +
                ", filename='" + filename +
                ", attachmentType='" + attachmentType +
                ", contentId='" + contentId +
                ", transferEncoding='" + transferEncoding +
                ", downloadPath='" + downloadPath +
                ", attachmentSize=" + attachmentSize +
                ", attachmentHumanSize='" + attachmentHumanSize +
                '}';
    }
}
