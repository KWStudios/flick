package io.flick.flick.networking;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Implements FlickNetworkClient to provide an interface between flick and HTTP servers.
 * <p>
 * Created by koray on 24/01/2017.
 */
public class FlickHTTPClient implements FlickNetworkClient {

    private OkHttpClient client = new OkHttpClient();
    private HashMap<String, String> headers = new HashMap<String, String>();

    public FlickHTTPClient() {
        // TODO: Is this the right location? Maybe the HTTPClient should not know anything about the default headers?
        headers.put("Accept", "application/vnd.api+json");
        headers.put("Content-Type", "application/vnd.api+json");
    }

    @Override
    public void request(@NotNull FlickHTTPMethod method, @NotNull String url,
        @Nullable FlickNetworkClientCallback callback) throws HTTPMethodNotSupportedException {
        request(method, url, null, callback);
    }

    @Override
    public void request(@NotNull FlickHTTPMethod method, @NotNull String url, @Nullable String payload,
        @Nullable FlickNetworkClientCallback callback) throws HTTPMethodNotSupportedException {
        Request.Builder requestBuilder = new Request.Builder();

        requestBuilder.url(url);

        for (Map.Entry<String, String> entry : headers.entrySet()) {
            requestBuilder.addHeader(entry.getKey(), entry.getValue());
        }

        RequestBody body = RequestBody.create(null, payload == null ? "" : payload);

        switch (method) {
        case GET:
            requestBuilder.get();
            break;
        case POST:
            requestBuilder.post(body);
            break;
        case PUT:
            requestBuilder.put(body);
            break;
        case PATCH:
            requestBuilder.patch(body);
            break;
        case DELETE:
            requestBuilder.delete(body);
            break;
        default:
            throw new HTTPMethodNotSupportedException(
                "Method " + method.toString() + " is not supported by FlickHTTPClient");
        }

        Request request = requestBuilder.build();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                if (callback != null) {
                    FlickNetworkError error = new FlickNetworkError("The request failed and could not be sent.",
                        e.getMessage());
                    callback.callback(-1, null, error);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (callback != null) {
                    callback.callback(response.code(), response.body().string(), null);
                }
            }
        });
    }

    public void addHeader(String key, String value) {
        headers.put(key, value);
    }

    public void removeHeader(String key) {
        headers.remove(key);
    }
}
