package io.flick.flick.networking;

/**
 * Describes a NetworkError.
 * 
 * @author Koray
 *
 */
public class FlickNetworkError {

    private String summary;
    private String detail;

    public FlickNetworkError(String summary, String detail) {
        this.summary = summary;
        this.detail = detail;
    }

    /**
     * Returns a string which describes this FlickNetworkError in order to be
     * easily debuggable.
     * 
     * @return A string which describes this error.
     */
    public String string() {
        return "{\n" +
            "'summary': " + summary + "," +
            "'detail': " + detail +
            "\n}";
    }

    @Override
    public String toString() {
        return string();
    }
}
