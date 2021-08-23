package request.experiments;

import config.Headers;
import config.Urls;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.BodyListExperiments;
import models.ResponseCreatesExperiments;

import static io.restassured.RestAssured.given;

public class RequestListExperiments {

    private static String path = "/experiments";
    public static ResponseCreatesExperiments responseCreatesExperimentsReturn;

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


    public static ResponseCreatesExperiments infoForExperimentCreate(ResponseCreatesExperiments responseCreatesExperiments){
        responseCreatesExperimentsReturn = new ResponseCreatesExperiments();
        responseCreatesExperimentsReturn.setId(responseCreatesExperiments.getId());
            responseCreatesExperimentsReturn.setName(responseCreatesExperiments.getName());
            return responseCreatesExperimentsReturn;
    }

}
