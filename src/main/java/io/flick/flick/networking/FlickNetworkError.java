package io.flick.flick.networking;

/**
 * Describes a NetworkError.
 * 
 * @author Koray
 *
 */
public interface FlickNetworkError {

    /**
     * Returns a string which describes this FlickNetworkError in order to be
     * easily debuggable.
     * 
     * @return A string which describes this error.
     */
    String string();
}
