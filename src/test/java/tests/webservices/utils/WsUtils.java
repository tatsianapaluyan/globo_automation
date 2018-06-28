package tests.webservices.utils;

import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WsUtils {

    public static StringBuffer parseResponse(CloseableHttpResponse response) throws IOException {
        BufferedReader rd = new BufferedReader((new InputStreamReader(response.getEntity().getContent())));
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        System.out.println(result);
        return result;
    }
}
