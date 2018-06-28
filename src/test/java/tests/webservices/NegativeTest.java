//package tests.webservices;
//
//import com.sun.security.ntlm.сlient;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class NegativeTest extends сlient {
//
//
//    @Test(description = "Negative test")
//    public void negativeTest() throws IOException {
//        String URL = "http://services.groupkt.com/state/get/USA/111";
//        HttpGet httpPost = new HttpGet(URL);
//        CloseableHttpResponse response = client.execute(httpPost);
//        System.out.println("Response status code is " + response.getStatusLine().getStatusCode());
//        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
//        BufferedReader rd = new BufferedReader((new InputStreamReader(response.getEntity().getContent())));
//        StringBuffer result = new StringBuffer();
//        String line = "";
//        while ((line = rd.readLine()) != null) {
//            result.append(line);
//        }
//        System.out.println(result);
//        Assert.assertTrue(result.toString().contains("No matching state found for requested code"));
//    }
//
//}
