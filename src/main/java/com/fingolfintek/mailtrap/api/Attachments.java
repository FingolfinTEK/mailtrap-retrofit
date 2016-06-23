package com.fingolfintek.mailtrap.api;

import java.util.List;

import com.fingolfintek.mailtrap.model.Attachment;
import com.fingolfintek.mailtrap.model.Message;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Attachments {

    @GET("/api/v1/inboxes/{inboxId}/messages/{messageId}/attachments")
    Call<List<Attachment>> listMessageAttachments(@Path("inboxId") String inboxId, @Path("messageId") String messageId);

    @GET("/api/v1/inboxes/{inboxId}/messages/{messageId}/attachments/{attachmentId}")
    Call<Message> showAttachment(
            @Path("inboxId") String inboxId, @Path("messageId") String messageId, @Path("attachmentId") String attachmentId);

    @GET("/api/v1/inboxes/{inboxId}/messages/{messageId}/attachments/{attachmentId}/download")
    Call<ResponseBody> downloadAttachment(
            @Path("inboxId") String inboxId, @Path("messageId") String messageId, @Path("attachmentId") String attachmentId);
}
