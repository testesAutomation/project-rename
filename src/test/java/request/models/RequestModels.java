package request.models;

import config.Headers;
import config.Urls;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.models.ResponseCreateModels;

import static config.Paths.*;
import static io.restassured.RestAssured.given;

public class RequestModels {

    public static ResponseCreateModels responseCreateModels;
    static ValidatableResponse response;

    public static ValidatableResponse createModels(String token) {

        response =  given()
                .log()
                .all()
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .post(Urls.ROOT.getUrl() + PATH_MODELS)
                .then()
                .log().all();

        if(response.extract().statusCode() == 200) {
            responseCreateModels = response.extract().as(ResponseCreateModels.class);
        }
        return response;
    }

    public static ValidatableResponse getModelsById(ResponseCreateModels responseCreateModels, String token) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .pathParam("id_models",responseCreateModels)
                .get(Urls.ROOT.getUrl() + PATH_MODELS_BY_ID)
                .then()
                .log().all();
        return response;
    }

    public static ValidatableResponse getListModels(String token) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .get(Urls.ROOT.getUrl() + PATH_MODELS)
                .then()
                .log().all();
        return response;
    }

    public static ValidatableResponse deleteModelsById(ResponseCreateModels responseCreateModels, String token) {

        return given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader() + token)
                .pathParam("id_models",responseCreateModels)
                .delete(Urls.ROOT.getUrl() + PATH_MODELS_BY_ID)
                .then()
                .log().all();

    }
}
