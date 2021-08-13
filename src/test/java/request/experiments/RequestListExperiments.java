package request.experiments;

import config.Body;
import config.Headers;
import config.Token;
import config.Urls;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.BodyListExperiments;

import static io.restassured.RestAssured.given;

public class RequestListExperiments {

    private static String path = "/experiments";

    public static ValidatableResponse listExperiments(BodyListExperiments bodyListExperiments, String token) {

        return given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .param("page", bodyListExperiments.getPage())
                .param("size", bodyListExperiments.getSize())
                .param("sort", bodyListExperiments.getSort())
                .when()
                .post(Urls.ROOT_EXPERIMENTS.getUrl() + path)
                .then()
                .log().all();
    }


}
