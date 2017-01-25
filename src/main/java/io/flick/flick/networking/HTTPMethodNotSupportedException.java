package io.flick.flick.networking;

/**
 * Describes an exception which indicates that a given HTTP method is not supported.
 * <p>
 * Created by koray on 24/01/2017.
 */
public class HTTPMethodNotSupportedException extends RuntimeException {

    public HTTPMethodNotSupportedException(String s) {
        super(s);
    }
}
