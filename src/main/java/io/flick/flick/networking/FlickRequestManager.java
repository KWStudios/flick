package io.flick.flick.networking;

import okhttp3.*;

import java.io.IOException;

/**
 * Manages all different sorts of requests with okhttp and executes given
 * callbacks.
 * <p>
 * Created by Koray on 21.01.2017.
 */
public class FlickRequestManager {

    private String baseUrl;

    private OkHttpClient client;

    public FlickRequestManager(String baseUrl) {
        this.baseUrl = baseUrl;

        this.client = new OkHttpClient();
    }

    public void sendRequest(String path, final Callback callback) {
        Request request = new Request.Builder().url(baseUrl + path).build();

        client.newCall(request).enqueue(new Callback() {

            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                if (callback != null)
                    callback.onFailure(call, e);
            }

            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
                if (callback != null)
                    callback.onResponse(call, response);
            }
        });
    }

    public void sendRequest(String path) {
        sendRequest(path, null);
    }

    public void test(FlickCallback callback) {

    }
}

interface FlickCallback {

    void onSuccess(Call call, Response response);
}
