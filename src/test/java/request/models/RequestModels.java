package request.models;

import config.Headers;
import config.Urls;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.models.BodyCreateModels;
import models.models.ResponseModels;

import static config.Paths.*;
import static io.restassured.RestAssured.given;

public class RequestModels {

    public static ResponseModels responseModels;
    static ValidatableResponse response;

    public static ValidatableResponse createModels(BodyCreateModels bodyCreateModels, String token) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .body(bodyCreateModels)
                .post(Urls.ROOT.getUrl() + PATH_MODELS)
                .then()
                .log().all();

        responseModels = response.extract().as(ResponseModels.class);

        return response;
    }

    public static ValidatableResponse deleteModelsById(ResponseModels responseCreateModels, String token) {

        return given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader() + token)
                .pathParam("id_models",responseCreateModels.getId())
                .delete(Urls.ROOT.getUrl() + PATH_MODELS_BY_ID)
                .then()
                .log().all();

    }

}
