package io.flick.flick.networking;

public interface FlickNetworkClient {

    void request(FlickHTTPMethod method, String url, FlickNetworkClientCallback callback);
    
    void request(FlickHTTPMethod method, String url, String payload, FlickNetworkClientCallback callback);
}
