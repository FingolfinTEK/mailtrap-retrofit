package com.fingolfintek.mailtrap.api;

import java.util.List;

import com.fingolfintek.mailtrap.model.Message;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Messages {

    @GET("/api/v1/inboxes/{inboxId}/messages")
    Call<List<Message>> listMessages(@Path("inboxId") String inboxId);

    @GET("/api/v1/inboxes/{inboxId}/messages/{messageId}")
    Call<Message> showMessage(@Path("inboxId") String inboxId, @Path("messageId") String messageId);

    @DELETE("/api/v1/inboxes/{inboxId}/messages/{messageId}")
    Call<Message> deleteMessage(@Path("inboxId") String inboxId, @Path("messageId") String messageId);
}
