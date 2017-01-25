package io.flick.flick.networking;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The interface between flick and the server. Not protocol dependent, can be implemented with HTTP, websockets or any
 * other transport protocol.
 */
public interface FlickNetworkClient {

    /**
     * Sends a request to the given {@code url} with the given {@code method}.
     * <p>
     * Once the request finished executing, either because of an error or because the response was received
     * successfully, the {@code callback} will be executed.
     * <p>
     * Throws a {@code HTTPMethodNotSupportedException} if the given {@code method} is not supported.
     * <p>
     * {@code url} is expected to be a proper formatted URL as described in RFC 2396.
     *
     * @param method   The method to use for this request.
     * @param url      The url where the request should go to.
     * @param callback The callback which will be called after the request finished executing.
     * @throws HTTPMethodNotSupportedException If the given {@code method} is not supported by this client.
     */
    void request(@NotNull FlickHTTPMethod method, @NotNull String url, @Nullable FlickNetworkClientCallback callback)
        throws HTTPMethodNotSupportedException;

    /**
     * Sends a request to the given {@code url} with the given {@code method} and the given {@code payload} as the body.
     * <p>
     * Once the request finished executing, either because of an error or because the response was received
     * successfully, the {@code callback} will be executed.
     * <p>
     * Throws a {@code HTTPMethodNotSupportedException} if the given {@code method} is not supported.
     * <p>
     * {@code url} is expected to be a proper formatted URL as described in RFC 2396.
     *
     * @param method   The method to use for this request.
     * @param url      The url where the request should go to.
     * @param payload  The body data which will be included into the request, or null if there should not be a body.
     * @param callback The callback which will be called after the request finished executing.
     * @throws HTTPMethodNotSupportedException If the given {@code method} is not supported by this client.
     */
    void request(@NotNull FlickHTTPMethod method, @NotNull String url, @Nullable String payload,
        @Nullable FlickNetworkClientCallback callback) throws HTTPMethodNotSupportedException;
}
