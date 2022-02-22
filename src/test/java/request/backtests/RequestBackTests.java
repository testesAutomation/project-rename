package request.backtests;

import config.Headers;
import config.Urls;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.backtest.BodyCreateBackTests;
import models.backtest.BodyPutBackTests;
import models.backtest.ResponseBackTests;

import static config.Paths.*;
import static io.restassured.RestAssured.given;

public class RequestBackTests {

    public static ResponseBackTests responseBackTest;
    static ValidatableResponse response;

    public static ValidatableResponse createBackTest(BodyCreateBackTests bodyCreateBackTest, String token) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .body(bodyCreateBackTest)
                .post(Urls.ROOT.getUrl() + PATH_BACKTEST)
                .then()
                .log().all();

        return response;
    }

    public static void extractResponse(ValidatableResponse responseParam){
        responseBackTest = responseParam.extract().as(ResponseBackTests.class);
    }

    public static ValidatableResponse getListBackTest(String token) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .get(Urls.ROOT.getUrl() + PATH_BACKTEST)
                .then()
                .log().all();

        return response;
    }

    public static ValidatableResponse getBackTestsById(ResponseBackTests responseBackTest, String token) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .pathParam("id_backtests",responseBackTest.getId())
                .get(Urls.ROOT.getUrl() + PATH_BACKTEST_BY_ID)
                .then()
                .log().all();

        return response;
    }

    public static ValidatableResponse deleteBackTestsById(ResponseBackTests responseBackTest, String token) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .pathParam("id_backtests",responseBackTest.getId())
                .delete(Urls.ROOT.getUrl() + PATH_BACKTEST_BY_ID)
                .then()
                .log().all();

        return response;
    }

    public static ValidatableResponse putBackTestsById(BodyPutBackTests bodyPutBackTests, String token) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .pathParam("id_backtests", responseBackTest.getId())
                .body(bodyPutBackTests)
                .put(Urls.ROOT.getUrl() + PATH_BACKTEST_ANALYST)
                .then()
                .log().all();

        return response;
    }

}
