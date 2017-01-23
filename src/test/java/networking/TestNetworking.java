package networking;

import static org.junit.Assert.*;

import io.flick.flick.networking.FlickRequestManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by koray on 23/01/2017.
 */
public class TestNetworking {

    private FlickRequestManager manager;

    @Before
    public void setup() throws Exception {
        manager = new FlickRequestManager("https://httpbin.org");
    }

    @After
    public void tearDown() throws Exception {
        manager = null;
        assertNull(manager);
    }

    @Test
    public void testRequest() {
        manager.sendRequest("/get");
    }
}
