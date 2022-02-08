package request.models;

import config.Headers;
import config.Urls;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.models.BodyCreateModels;
import models.models.BodyModelsColumns;
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

        if(response.extract().statusCode() == 200) {
            responseModels = response.extract().as(ResponseModels.class);
        }
        return response;
    }

    public static ValidatableResponse getModelsById(ResponseModels responseCreateModels, String token) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .pathParam("id_models",responseCreateModels.getId())
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

    public static ValidatableResponse pathModels(ResponseModels responseCreateModels, String token, String name) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .pathParam("id_models",responseCreateModels.getId())
                .body("{\n" +
                        "  \"name\":\""+ name +"\"\n" +
                        "  \n" +
                        "}")
                .patch(Urls.ROOT.getUrl() + PATH_MODELS_BY_ID)
                .then()
                .log().all();
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


    public static ValidatableResponse getPreprocessingModels(ResponseModels responseCreateModels, String token) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .pathParam("id_models",responseCreateModels.getId())
                .get(Urls.ROOT.getUrl() + PATH_MODELS_PREPROCESSING)
                .then()
                .log().all();
        return response;
    }

    public static ValidatableResponse getModelsColumns(ResponseModels responseCreateModels, BodyModelsColumns bodyModelsColumns, String token) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .pathParam("id_models",responseCreateModels.getId())
                .param("page", bodyModelsColumns.getPage())
                .param("size", bodyModelsColumns.getSize())
                .param("sort", bodyModelsColumns.getSort())
                .param("includeExperian", bodyModelsColumns.getIncludeExperian())
                .param("onlyRelevant", bodyModelsColumns.getOnlyRelevant())
                .param("name", bodyModelsColumns.getName())
                .get(Urls.ROOT.getUrl() + PATH_MODELS_COLUMNS)
                .then()
                .log().all();
        return response;
    }
}
