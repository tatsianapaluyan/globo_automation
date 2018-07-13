package tests.webservices.wstests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.webservices.сlient.HttpClient;

import java.io.IOException;
import java.util.Map;

public class WsErrorCode {
    private static final String URL = "http://services.groupkt.com/css/app.css";
    private Logger logger = Logger.getLogger(getClass());

    @Test
    public void negativeScenario() throws IOException {
        HttpClient client = new HttpClient();
        Map<String, Object> result = client.doGetRequest(URL);
        logger.info("Status Code check");
        Assert.assertEquals(result.get("code"), 404, "Unexpected status code!");
        String expectedResponse = "HTTP Status 404 – Not Found";
        Assert.assertTrue(result.get("content").toString().contains(expectedResponse), "Wrong response!");
    }

}
