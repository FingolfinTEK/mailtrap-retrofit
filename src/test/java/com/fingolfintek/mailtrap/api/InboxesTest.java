package com.fingolfintek.mailtrap.api;

import java.util.List;

import com.fingolfintek.mailtrap.Mailtrap;
import com.fingolfintek.mailtrap.model.Inbox;
import com.fingolfintek.mailtrap.util.Resources;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.patch;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class InboxesTest {

    private static final String MOCK_URI = "http://localhost:18080";

    @Rule
    public WireMockRule mockMailtrap = new WireMockRule(18080);

    private Inboxes api;

    @Before
    public void setUp() throws Exception {
        api = Mailtrap.mailtrapPointingAtUriUsingApiToken(Inboxes.class, MOCK_URI, "token");
    }

    @Test
    public void listInboxes() throws Exception {
        String response = Resources.resourceAsString("/inboxes.json");
        mockMailtrap.stubFor(get(urlEqualTo("/api/v1/inboxes?api_token=token"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.SC_OK)
                        .withBody(response)));

        List<Inbox> inboxes = api.listInboxes().execute().body();
        assertThat(inboxes).extracting("id").containsExactly("3");
        assertThat(inboxes).extracting("name").containsExactly("Test inbox");
        assertThat(inboxes).extracting("username").containsExactly("1da91769512fb");
    }

    @Test
    public void showInbox() throws Exception {
        String response = Resources.resourceAsString("/inbox.json");
        mockMailtrap.stubFor(get(urlEqualTo("/api/v1/inboxes/3?api_token=token"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.SC_OK)
                        .withBody(response)));

        Inbox inbox = api.showInbox("3").execute().body();
        assertThat(inbox.getId()).isEqualTo("3");
        assertThat(inbox.getName()).isEqualTo("Test inbox");
        assertThat(inbox.getUsername()).isEqualTo("1da91769512fb");
    }

    @Test
    public void deleteInbox() throws Exception {
        String response = Resources.resourceAsString("/inbox.json");
        mockMailtrap.stubFor(delete(urlEqualTo("/api/v1/inboxes/3?api_token=token"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.SC_OK)
                        .withBody(response)));

        Inbox inbox = api.deleteInbox("3").execute().body();
        assertThat(inbox.getId()).isEqualTo("3");
        assertThat(inbox.getName()).isEqualTo("Test inbox");
        assertThat(inbox.getUsername()).isEqualTo("1da91769512fb");
    }

    @Test
    public void cleanInbox() throws Exception {
        String response = Resources.resourceAsString("/inbox.json");
        mockMailtrap.stubFor(patch(urlEqualTo("/api/v1/inboxes/3/clean?api_token=token"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.SC_OK)
                        .withBody(response)));

        Inbox inbox = api.cleanInbox("3").execute().body();
        assertThat(inbox.getId()).isEqualTo("3");
        assertThat(inbox.getName()).isEqualTo("Test inbox");
        assertThat(inbox.getUsername()).isEqualTo("1da91769512fb");
    }

    @Test
    public void listMessageAttachments() throws Exception {

    }

    @Test
    public void showAttachment() throws Exception {

    }

    @Test
    public void downloadAttachment() throws Exception {

    }

}