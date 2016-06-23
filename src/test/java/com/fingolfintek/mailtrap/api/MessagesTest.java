package com.fingolfintek.mailtrap.api;

import java.util.List;

import com.fingolfintek.mailtrap.Mailtrap;
import com.fingolfintek.mailtrap.model.Message;
import com.fingolfintek.mailtrap.util.Resources;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class MessagesTest {

    private static final String MOCK_URI = "http://localhost:18080";

    @Rule
    public WireMockRule mockMailtrap = new WireMockRule(18080);

    private Messages api;

    @Before
    public void setUp() throws Exception {
        api = Mailtrap.mailtrapPointingAtUriUsingApiToken(Messages.class, MOCK_URI, "token");
    }


    @Test
    public void listMessages() throws Exception {
        String response = Resources.resourceAsString("/messages.json");
        mockMailtrap.stubFor(get(urlEqualTo("/api/v1/inboxes/3/messages?api_token=token"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.SC_OK)
                        .withBody(response)));

        List<Message> messages = api.listMessages("3").execute().body();
        assertThat(messages).extracting("id").containsExactly("209433906");
        assertThat(messages).extracting("inboxId").containsExactly("3");
        assertThat(messages).extracting("subject").containsExactly("Subject");
        assertThat(messages).extracting("fromEmail").containsExactly("from@email.com");
        assertThat(messages).extracting("fromName").containsExactly("From");
        assertThat(messages).extracting("toEmail").containsExactly("to@email.com");
        assertThat(messages).extracting("toName").containsExactly("To");
        assertThat(messages).extracting("htmlBody").containsExactly("HTML");
    }

    @Test
    public void showMessage() throws Exception {
        String response = Resources.resourceAsString("/message.json");
        mockMailtrap.stubFor(get(urlEqualTo("/api/v1/inboxes/3/messages/209433906?api_token=token"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.SC_OK)
                        .withBody(response)));

        Message messages = api.showMessage("3", "209433906").execute().body();
        assertThat(messages.getId()).isEqualTo("209433906");
        assertThat(messages.getInboxId()).isEqualTo("3");
        assertThat(messages.getSubject()).isEqualTo("Subject");
        assertThat(messages.getFromEmail()).isEqualTo("from@email.com");
        assertThat(messages.getFromName()).isEqualTo("From");
        assertThat(messages.getToEmail()).isEqualTo("to@email.com");
        assertThat(messages.getToName()).isEqualTo("To");
        assertThat(messages.getHtmlBody()).isEqualTo("HTML");
    }

    @Test
    public void deleteMessage() throws Exception {
        String response = Resources.resourceAsString("/message.json");
        mockMailtrap.stubFor(delete(urlEqualTo("/api/v1/inboxes/3/messages/209433906?api_token=token"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.SC_OK)
                        .withBody(response)));

        Message messages = api.deleteMessage("3", "209433906").execute().body();
        assertThat(messages.getId()).isEqualTo("209433906");
        assertThat(messages.getInboxId()).isEqualTo("3");
        assertThat(messages.getSubject()).isEqualTo("Subject");
        assertThat(messages.getFromEmail()).isEqualTo("from@email.com");
        assertThat(messages.getFromName()).isEqualTo("From");
        assertThat(messages.getToEmail()).isEqualTo("to@email.com");
        assertThat(messages.getToName()).isEqualTo("To");
        assertThat(messages.getHtmlBody()).isEqualTo("HTML");
    }

}