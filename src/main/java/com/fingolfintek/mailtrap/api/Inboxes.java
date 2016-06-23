package com.fingolfintek.mailtrap.api;

import java.util.List;

import com.fingolfintek.mailtrap.model.Attachment;
import com.fingolfintek.mailtrap.model.Inbox;
import com.fingolfintek.mailtrap.model.Message;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface Inboxes {

    @GET("/api/v1/inboxes")
    Call<List<Inbox>> listInboxes();

    @GET("/api/v1/inboxes/{id}")
    Call<Inbox> showInbox(@Path("id") String id);

    @DELETE("/api/v1/inboxes/{id}")
    Call<Inbox> deleteInbox(@Path("id") String id);

    @PATCH("/api/v1/inboxes/{id}/clean")
    Call<Inbox> cleanInbox(@Path("id") String id);
}
