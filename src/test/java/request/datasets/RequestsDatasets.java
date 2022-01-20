package request.datasets;

import com.github.javafaker.Faker;
import config.Headers;
import config.Urls;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.datasets.ResponseCreateDatasets;
import models.experiments.ResponseCreatesExperiments;

import java.io.File;
import java.util.Locale;

import static config.Paths.*;
import static io.restassured.RestAssured.given;

public class RequestsDatasets {

    static ValidatableResponse response;
    public static ResponseCreateDatasets responseCreateDatasets;

    public static ValidatableResponse createDatasets(ResponseCreatesExperiments responseCreatesExperiments, String token, File file) {

        response =  given()
                .log()
                .all()
                .contentType("multipart/form-data")
                .multiPart("name", "DataSetAutomation")
                .multiPart("experimentId", responseCreatesExperiments.getId())
                .multiPart("file", file)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .post(Urls.ROOT_EXPERIMENTS.getUrl() + PATH_DATASETS)
                .then()
                .log().all();

        if(response.extract().statusCode() == 200) {
            responseCreateDatasets = response.extract().as(ResponseCreateDatasets.class);
        }
        return response;
    }

    public static ValidatableResponse getDatasetsById(ResponseCreateDatasets responseCreateDatasets, String token) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .pathParam("id_datasets",responseCreateDatasets.getId())
                .get(Urls.ROOT_EXPERIMENTS.getUrl() + PATH_DATASETS_BY_ID)
                .then()
                .log().all();
        return response;
    }


    public static ValidatableResponse getListDatasets(String token) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .get(Urls.ROOT_EXPERIMENTS.getUrl() + PATH_DATASETS)
                .then()
                .log().all();
        return response;
    }

    public static ValidatableResponse deleteDatasetsById(ResponseCreateDatasets responseCreateDatasets, String token) {

        return given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader() + token)
                .pathParam("id_datasets",responseCreateDatasets.getId())
                .delete(Urls.ROOT_EXPERIMENTS.getUrl() + PATH_DATASETS_BY_ID)
                .then()
                .log().all();

    }

    public static ValidatableResponse patchDatasetsById(ResponseCreateDatasets responseCreateDatasets, String token) {
        Faker faker = new Faker(new Locale("pt-BR"));

        String bodyPatch = "{\n" +
                "  \"name\": \""+ RequestsDatasets.responseCreateDatasets.getName() + "\",\n" +
                "  \"name\": \""+ faker.lorem().characters(7) +"\"\n" +
                "}";


        response =   given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .pathParam("id_datasets",responseCreateDatasets.getId())
                .body(bodyPatch)
                .patch(Urls.ROOT_EXPERIMENTS.getUrl() + PATH_DATASETS_BY_ID)
                .then()
                .log().all();
        return response;
    }

    public static ValidatableResponse getDatasetsTimeframes(ResponseCreateDatasets responseCreateDatasets, String token) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .pathParam("id_datasets",responseCreateDatasets.getId())
                .get(Urls.ROOT_EXPERIMENTS.getUrl() + PATH_DATASETS_TIMEFRAMES)
                .then()
                .log().all();
        return response;
    }


    public static ValidatableResponse getDatasetsColumns(ResponseCreateDatasets responseCreateDatasets, String token) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .pathParam("id_datasets", responseCreateDatasets.getId())
                .get(Urls.ROOT_EXPERIMENTS.getUrl() + PATH_DATASETS_COLUMNS)
                .then()
                .log().all();
        return response;
    }



}
