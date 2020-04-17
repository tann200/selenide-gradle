package restAssuredClients;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

public class basicRestAssuredClient {
    private final Logger logger = LoggerFactory.getLogger(basicRestAssuredClient.class);

    private void logCallResponseTime(String endpoint, Response response) {
        logger.info("Response time {} {} ms", endpoint, response.getTime());
    }


    public basicRestAssuredClient(){

    }

    private RequestSpecification requestSpec = new RequestSpecBuilder()
            .setRelaxedHTTPSValidation()
            .setContentType(ContentType.JSON)
            .addFilter(new AllureRestAssured())
            .log(LogDetail.PARAMS)
            .build();
    private ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.PARAMS)
            .build();



    @Step("Get authorization token")
    public Object authentication(String endpoint, String username, String password) {

        JSONObject loginPayload = new JSONObject();
        loginPayload.put("username", username);
        loginPayload.put("password", password);

        Response response =
                given(requestSpec)
                        .body(loginPayload.toString())
                        .when().post(endpoint + "/api/v1/authenticate")
                        .then()
                        .spec(responseSpec)
                        .extract()
                        .response();

        Object token = (response.getBody().jsonPath().getString("token"));
        logCallResponseTime(endpoint, response);
        return token;
    }

    //GET request with some string as path parameter
    @Step("doing get request")
    public Response basicGetRequest(String endpoint, Object token, String  stringValue){
        logger.info("Get request using endpoint, token and some string");


        Response response =
                given()
                        .header("Authorization", token)
                        .pathParam("stringValue", stringValue)
                        .spec(requestSpec)
                        .when()
                        .get(endpoint + "/path/{stringValue}")
                        .then()
                        .spec(responseSpec)
                        .extract()
                        .response();

        logCallResponseTime(endpoint, response);
        return response;
    }
}
