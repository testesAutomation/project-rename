package request.experiments;

import config.Headers;
import config.Urls;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.BodyCreatesExperiments;

import static io.restassured.RestAssured.given;

public class RequestCreatesExperiments {

    private static String path = "/experiments";

    public static ValidatableResponse createsExperiments(BodyCreatesExperiments bodyCreatesExperiments, String token) {

        return given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .body(bodyCreatesExperiments)
                .post(Urls.ROOT_EXPERIMENTS.getUrl() + path)
                .then()
                .log().all();
    }
}
