package Api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class PostmanEchoAPITest {
    private final String URL = "https://postman-echo.com";

    @Test
    public void testGetRequest() {
        api.reqres.spec.Specifications.installSpecification(api.reqres.spec.Specifications.requestSpec(URL), api.reqres.spec.Specifications.responseSpecOK200());
        Response response = given()
                .body("foo1=bar1&foo2=bar2")
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then().log().all()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        assertEquals("443", jsonPath.get("headers.'x-forwarded-port'"));
        assertEquals("postman-echo.com", jsonPath.get("headers.host"));
        assertNotNull(jsonPath.get("headers.'x-amzn-trace-id'"));
        assertEquals("19", jsonPath.get("headers.'content-length'"));
        assertEquals("*/*", jsonPath.get("headers.accept"));
        assertEquals("gzip,deflate", jsonPath.get("headers.'accept-encoding'"));
    }

    @Test
    public void testPostRawTextRequest() {
        api.reqres.spec.Specifications.installSpecification(api.reqres.spec.Specifications.requestSpec(URL), api.reqres.spec.Specifications.responseSpecOK200());
        Response response = given()
                .body("This is expected to be sent back as part of response body.")
                .when()
                .post("/post")
                .then().log().all()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        assertEquals("443", jsonPath.get("headers.'x-forwarded-port'"));
        assertEquals("postman-echo.com", jsonPath.get("headers.host"));
        assertNotNull(jsonPath.get("headers.'x-amzn-trace-id'"));
        assertEquals("58", jsonPath.get("headers.'content-length'"));
        assertEquals("*/*", jsonPath.get("headers.accept"));
        assertEquals("gzip,deflate", jsonPath.get("headers.'accept-encoding'"));
    }
    @Test
    public void testPostFromDataRequest() {
        api.reqres.spec.Specifications.installSpecification(api.reqres.spec.Specifications.requestSpec(URL), api.reqres.spec.Specifications.responseSpecOK200());
        Response response = given()
                .body("foo1=bar1&foo2=bar2")
                .when()
                .post("/post")
                .then().log().all()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        assertEquals("443", jsonPath.get("headers.'x-forwarded-port'"));
        assertEquals("postman-echo.com", jsonPath.get("headers.host"));
        assertNotNull(jsonPath.get("headers.'x-amzn-trace-id'"));
        assertEquals("19", jsonPath.get("headers.'content-length'"));
        assertEquals("*/*", jsonPath.get("headers.accept"));
        assertEquals("gzip,deflate", jsonPath.get("headers.'accept-encoding'"));
    }

    @Test
    public void testPutRequest() {
        api.reqres.spec.Specifications.installSpecification(api.reqres.spec.Specifications.requestSpec(URL), api.reqres.spec.Specifications.responseSpecOK200());
        Response response = given()
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        assertEquals("443", jsonPath.get("headers.x-forwarded-port"));
        assertEquals("postman-echo.com", jsonPath.get("headers.host"));
        assertNotNull(jsonPath.get("headers.x-amzn-trace-id"));
        assertEquals("58", jsonPath.get("headers.content-length"));
        assertEquals("*/*", jsonPath.get("headers.accept"));
        assertEquals("gzip,deflate", jsonPath.get("headers.accept-encoding"));
    }

    @Test
    public void testPatchRequest() {
        api.reqres.spec.Specifications.installSpecification(api.reqres.spec.Specifications.requestSpec(URL), api.reqres.spec.Specifications.responseSpecOK200());
        Response response = given()
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        assertEquals("443", jsonPath.get("headers.x-forwarded-port"));
        assertEquals("postman-echo.com", jsonPath.get("headers.host"));
        assertNotNull(jsonPath.get("headers.x-amzn-trace-id"));
        assertEquals("58", jsonPath.get("headers.content-length"));
        assertEquals("*/*", jsonPath.get("headers.accept"));
        assertEquals("gzip,deflate", jsonPath.get("headers.accept-encoding"));
    }

    @Test
    public void testDeleteRequestWithApiKey() {
        api.reqres.spec.Specifications.installSpecification(api.reqres.spec.Specifications.requestSpec(URL), api.reqres.spec.Specifications.responseSpecOK200());
        Response response = given()
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        assertEquals(response.getStatusCode(), 200);
        assertEquals("This is expected to be sent back as part of response body.", jsonPath.get("data"));
        assertEquals("443", jsonPath.get("headers.x-forwarded-port"));
        assertEquals("postman-echo.com", jsonPath.get("headers.host"));
        assertNotNull(jsonPath.get("headers.x-amzn-trace-id"));
        assertEquals("58", jsonPath.get("headers.content-length"));
        assertEquals("*/*", jsonPath.get("headers.accept"));
        assertEquals("gzip,deflate", jsonPath.get("headers.accept-encoding"));
    }
}

