package request.datasets;

import com.github.javafaker.Faker;
import config.Headers;
import config.Urls;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.datasets.ResponseCreateDatasets;
import models.experiments.BodyCreatesExperiments;
import request.experiments.RequestsExperiments;

import java.io.File;
import java.util.Locale;

import static io.restassured.RestAssured.given;

public class RequestsDatasets {

    private static String path = "/datasets";
    static ValidatableResponse response;
    public static ResponseCreateDatasets responseCreateDatasets;

    public static ValidatableResponse createsDatasetsWithExperiment(String token) {

        //Create a new experiment
        BodyCreatesExperiments bodyCreatesExperiments = new BodyCreatesExperiments();
        RequestsExperiments.createsExperiments(bodyCreatesExperiments, token);

        response =  given()
                .log()
                .all()
                .contentType("multipart/form-data")
                .multiPart("name", "DataSetAutomation")
                .multiPart("experimentId", RequestsExperiments.responseCreatesExperiments.getId())
                .multiPart("file", new File("src/test/resouces/dataset_example.csv"))
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .post(Urls.ROOT_EXPERIMENTS.getUrl() + path)
                .then()
                .log().all();

        if(response.extract().statusCode() == 200) {
            responseCreateDatasets = response.extract().as(ResponseCreateDatasets.class);
        }
        return response;
    }

    public static ValidatableResponse createsDatasetWithoutAnyId(String token) {

        response =  given()
                .log()
                .all()
                .contentType("multipart/form-data")
                .multiPart("name", "DataSetAutomation")
                .multiPart("file", new File("src/test/resouces/dataset_example.csv"))
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

        response =   given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .param("datasetId", responseCreateDatasets.getId())
                .delete(Urls.ROOT_EXPERIMENTS.getUrl() + path)
                .then()
                .log().all();
        return response;
    }

    public static ValidatableResponse patchDatasetsById(ResponseCreateDatasets responseCreateDatasets, String token) {
        Faker faker = new Faker(new Locale("pt-BR"));
        responseCreateDatasets.setName(faker.lorem().characters(9));

        String bodyPatch = "{\n" +
                "  \"name\": \""+ responseCreateDatasets.getName() +"\",\n" +
                "  \"defaultTarget\": \""+ "Automação" + faker.lorem().characters(9)+"\"\n" +
                "}";

        response =   given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .param("datasetId", responseCreateDatasets.getId())
                .body(bodyPatch)
                .patch(Urls.ROOT_EXPERIMENTS.getUrl() + path)
                .then()
                .log().all();
        return response;
    }


}
