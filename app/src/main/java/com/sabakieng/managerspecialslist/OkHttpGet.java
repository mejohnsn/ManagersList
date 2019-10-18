package com.sabakieng.managerspecialslist;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OkHttpGet supports one method: get the request's response body as a String.
 */
class OkHttpGet {

    //OkHttpClient client = new OkHttpClient(); // network on main thread, so trying:

    /**
     *
     * @param url Complete URL to be fetched.
     * @return the response body as a String.
     * @throws IOException
     */
    String doGetRequest(String url) throws IOException {
    OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute(); // .execute tr4 synchronous call
        return response.body().string();
    }
}