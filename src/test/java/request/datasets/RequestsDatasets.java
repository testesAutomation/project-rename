package request.datasets;

import config.Headers;
import config.Urls;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.datasets.ResponseCreateDatasets;
import models.experiments.ResponseCreatesExperiments;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RequestsDatasets {

    private static String path = "/datasets";
    static ValidatableResponse response;
    public static ResponseCreateDatasets responseCreateDatasets;

    public static ValidatableResponse createsDatasetsWithExperiment(ResponseCreatesExperiments responseCreatesExperiments, String token, File file) {

        response =  given()
                .log()
                .all()
                .contentType("multipart/form-data")
                .multiPart("name", "DataSetAutomation")
                .multiPart("experimentId", responseCreatesExperiments.getId())
                .multiPart("file", file)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .post(Urls.ROOT_EXPERIMENTS.getUrl() + path)
                .then()
                .log().all();

        if(response.extract().statusCode() == 200) {
            responseCreateDatasets = response.extract().as(ResponseCreateDatasets.class);
        }
        return response;
    }

    public static ValidatableResponse createsDatasetWithoutAnyId(String token, File file) {

        response =  given()
                .log()
                .all()
                .contentType("multipart/form-data")
                .multiPart("name", "DataSetAutomation")
                .multiPart("file", file)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .post(Urls.ROOT_EXPERIMENTS.getUrl() + path)
                .then()
                .log().all();
        return response;
    }

    public static ValidatableResponse getDatasetsById(ResponseCreateDatasets responseCreateDatasets, String token) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .get(Urls.ROOT_EXPERIMENTS.getUrl() + path + "/" + responseCreateDatasets.getId())
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
                .get(Urls.ROOT_EXPERIMENTS.getUrl() + path)
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
                .delete(Urls.ROOT_EXPERIMENTS.getUrl() + path + "/" + responseCreateDatasets.getId())
                .then()
                .log().all();

    }

    public static ValidatableResponse patchDatasetsById(ResponseCreateDatasets responseCreateDatasets, String token, String bodyPatch) {

        response =   given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .body(bodyPatch)
                .patch(Urls.ROOT_EXPERIMENTS.getUrl() + path +  "/" + responseCreateDatasets.getId())
                .then()
                .log().all();
        return response;
    }


}
