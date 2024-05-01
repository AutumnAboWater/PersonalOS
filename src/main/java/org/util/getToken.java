package org.util;

import okhttp3.*;

import java.io.IOException;

public class getToken {

    static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();
    public getToken() throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/oauth/2.0/token?client_id=RMHLYl6GdLo9TUmvjeri8pl4&client_secret=MDOeHTtMxEOsOIw2qH3bb9rBC48HtjKE&grant_type=client_credentials")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        System.out.println(response.body().string());

    }
}
