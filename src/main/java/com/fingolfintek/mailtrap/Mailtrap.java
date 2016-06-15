package com.fingolfintek.mailtrap;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.HttpUrl;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @author Milos Milivojevic | mmilivojevic@deployinc.com
 */
public class Mailtrap {

    private static final String PRODUCTION_URI = "https://mailtrap.io";

    private static final ObjectMapper MAPPER = new ObjectMapper()
            .registerModules(new JavaTimeModule(), new Jdk8Module())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    public static <T> T mailtrapApiUsingApiToken(Class<T> api, String token) {
        return mailtrapPointingAtUriUsingApiToken(api, PRODUCTION_URI, token);
    }

    public static <T> T mailtrapPointingAtUriUsingApiToken(
            Class<T> api, String baseUri, String token) {
        return commonBuilderFor(baseUri)
                .client(mailtrapClientWithApiToken(token))
                .build()
                .create(api);
    }

    private static Retrofit.Builder commonBuilderFor(String baseUri) {
        return new Retrofit.Builder()
                .baseUrl(baseUri + "/")
                .addConverterFactory(JacksonConverterFactory.create(MAPPER));
    }

    private static OkHttpClient mailtrapClientWithApiToken(String token) {
        return new OkHttpClient.Builder()
                .addInterceptor(c -> addApiTokenParameter(c, token))
                .build();
    }

    private static okhttp3.Response addApiTokenParameter(Chain chain, String token) throws IOException {
        HttpUrl url = urlWithApiToken(chain, token);
        Request build = chain.request().newBuilder().url(url).build();
        return chain.proceed(build);
    }

    private static HttpUrl urlWithApiToken(Chain chain, String token) {
        return chain.request().url().newBuilder().addQueryParameter("api_token", token).build();
    }
}
