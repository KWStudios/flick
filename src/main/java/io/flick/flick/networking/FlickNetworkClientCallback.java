package io.flick.flick.networking;

import org.jetbrains.annotations.Nullable;

/**
 * Describes a NetworkClient callback which will be called after a network
 * request was made.
 *
 * @author Koray
 */
public interface FlickNetworkClientCallback {

    /**
     * Will be called after a network request.
     * <p>
     * The status code and the data string are fetched from the server's
     * response and {@code error} will be {@code null} if the request
     * was successful.
     * <p>
     * If the request was not successful, statusCode will be {@code -1} and
     * data will be {@code null}. {@code error} will be an instance of
     * {@code FlickNetworkError} which describes the details of the error
     * which happened.
     *
     * @param statusCode The status code of the response if the request was successful or -1.
     * @param data       The body of the response if the request was successful or null.
     * @param error      The error which happened during the request if the request was not successful or null.
     */
    void callback(int statusCode, @Nullable String data, @Nullable FlickNetworkError error);
}
