package tests.webservices.wstests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.webservices.сlient.HttpClient;

import java.io.IOException;
import java.util.Map;

public class NegativeResponse {

    public class NegativeScenario {
        private static final String URL = "http://services.groupkt.com/state/get/%s/%s";
        private String country = "USA";
        private String state = "noCode";

        @Test
        public void negativeScenario() throws IOException {
            String resultURL = String.format(URL, country, state);
            HttpClient client = new HttpClient();
            Map<String, Object> result = client.doGetRequest(resultURL);
            Assert.assertEquals(result.get("code"), 200, "Unexpected status code!");
            String errorMessage = String.format("No matching state found for requested code [%s->%s].", country, state);
            Assert.assertTrue(result.get("content").toString().contains(errorMessage), "Wrong error message!");
        }
    }
}
