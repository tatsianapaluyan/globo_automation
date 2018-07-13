package tests.webservices.wstests;

import loggerutils.CustomListener;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.webservices.сlient.HttpClient;

import java.io.IOException;
import java.util.Map;

public class PositiveResponse {

    @Listeners(CustomListener.class)
    public class PositiveScenario {
        private static final String URL = "http://services.groupkt.com/state/get/%s/%s";
        private String country = "USA";
        private String state = "CA";
        private Map<String, Object> result;
        private Logger logger = Logger.getLogger(getClass());
        CustomListener customListener = new CustomListener();

        @BeforeClass
        public void getResponse() throws IOException {
            String resultURL = String.format(URL, country, state);
            HttpClient client = new HttpClient();
            result = client.doGetRequest(resultURL);
        }

        @Test
        public void verifyStatusCode() {
            Assert.assertEquals(result.get("code"), 200, "Unexpected status code!");
        }

        @Test(dependsOnMethods = "verifyStateCode")
        public void verifyCountry() {
            String expectedCountry = String.format("\"country\" : \"%s\"", country);
            Assert.assertTrue(result.get("content").toString().contains(expectedCountry), "Wrong country!");
        }

    }
}
