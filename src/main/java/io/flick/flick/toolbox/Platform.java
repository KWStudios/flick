package io.flick.flick.toolbox;

/**
 * Access the platform specific features such as {@code runOnUiThread} on Android.
 *
 * Created by koray on 25/01/2017.
 */
public class Platform {

    private static Platform instance = new Platform();

    public static Platform getInstance() {
        return instance;
    }

    private Platform() {
    }
}
