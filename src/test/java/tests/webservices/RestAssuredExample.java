package tests.webservices;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class RestAssuredExample {

    private static final String URL = "http://services.groupkt.com/state/get/USA/CA";


    @Test
    public void test() {

        RestAssured.given().when().get(URL).then().
                statusCode(200).
                assertThat().body("s", equalTo("a"));
    }
}

