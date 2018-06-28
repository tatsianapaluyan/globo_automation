//package tests.webservices;
//
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
//
//import java.io.IOException;
//
//public class Preconditions {
//
//    protected static final String URI = "http://services.groupkt.com/state/get";
//
//    protected static CloseableHttpClient client;
//
//    @BeforeSuite
//    public void beforeMethod() {
//        client = сlient.getInstance();
//    }
//
//    @AfterSuite
//    public void afterMethod() throws IOException {
//        if (client != null) {
//            client.close();
//        }
//        client = null;
//    }
//
//}
