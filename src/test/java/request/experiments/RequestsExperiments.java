package request.experiments;

import config.Headers;
import config.Urls;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.BodyCreatesExperiments;
import models.ResponseCreatesExperiments;
import models.ResponseViaCep;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RequestsExperiments {

    private static String path = "/experiments";

    public static ResponseCreatesExperiments responseCreatesExperiments, updateResponseCreatesExperiments;
    static ValidatableResponse response;

    public static ValidatableResponse createsExperiments(BodyCreatesExperiments bodyCreatesExperiments, String token) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .body(bodyCreatesExperiments)
                .post(Urls.ROOT_EXPERIMENTS.getUrl() + path)
                .then()
                .log().all();

        responseCreatesExperiments = response.extract().as(ResponseCreatesExperiments.class);
        return response;
    }

    public static ValidatableResponse listExperiments(String token) {

        return given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .when()
                .get(Urls.ROOT_EXPERIMENTS.getUrl() + path)
                .then()
                .log().all();
    }

    public static ValidatableResponse listExperimentsById(ResponseCreatesExperiments responseCreatesExperiments, String token) {

        return given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .when()
                .get(Urls.ROOT_EXPERIMENTS.getUrl() + path + "/" + responseCreatesExperiments.getId())
                .then()
                .log().all();
    }

    public static ValidatableResponse putExperiments(ResponseCreatesExperiments responseCreatesExperimentsParam, String token) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .body(responseCreatesExperiments)
                .put(Urls.ROOT_EXPERIMENTS.getUrl() + path + "/" +responseCreatesExperimentsParam.getId())
                .then()
                .log().all();

        updateResponseCreatesExperiments = response.extract().as(ResponseCreatesExperiments.class);
        responseCreatesExperiments = updateResponseCreatesExperiments;
        return response;
    }

    public static ValidatableResponse deleteExperiments(ResponseCreatesExperiments responseCreatesExperiments, String token) {

        return given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .delete(Urls.ROOT_EXPERIMENTS.getUrl() + path +  "/" + responseCreatesExperiments.getId())
                .then()
                .log().all();
    }

}
