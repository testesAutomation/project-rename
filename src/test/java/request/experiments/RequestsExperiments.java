package request.experiments;

import config.Headers;
import config.Urls;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.experiments.BodyCreatesExperiments;
import models.experiments.ResponseCreatesExperiments;

import static config.Paths.PATH_EXPERIMENTS;
import static io.restassured.RestAssured.given;

public class RequestsExperiments {

    public static ResponseCreatesExperiments responseCreatesExperiments;
    static ValidatableResponse response;

    public static ValidatableResponse createsExperiments(BodyCreatesExperiments bodyCreatesExperiments, String token) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .body(bodyCreatesExperiments)
                .post(Urls.ROOT.getUrl() + PATH_EXPERIMENTS)
                .then()
                .log().all();

        if(response.extract().statusCode() == 200) {
            responseCreatesExperiments = response.extract().as(ResponseCreatesExperiments.class);
        }
        return response;
    }

    public static ValidatableResponse deleteExperiments(ResponseCreatesExperiments responseCreatesExperiments, String token) {

        return given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .delete(Urls.ROOT.getUrl() + PATH_EXPERIMENTS +  "/" + responseCreatesExperiments.getId())
                .then()
                .log().all();
    }
}
