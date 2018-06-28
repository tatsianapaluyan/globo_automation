package tests.webservices.сlient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import tests.webservices.utils.WsUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpClient {

    public Map<String, Object> doGetRequest(String URL) throws IOException {
        Map<String, Object> map = new HashMap<>();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(URL);
        CloseableHttpResponse response = client.execute(httpGet);
        map.put("code", response.getStatusLine().getStatusCode());
        map.put("content", WsUtils.parseResponse(response));
        client.close();
        return map;
    }
}