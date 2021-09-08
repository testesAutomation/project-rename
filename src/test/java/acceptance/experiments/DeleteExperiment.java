package acceptance.experiments;

import io.restassured.response.ValidatableResponse;
import models.experiments.ResponseCreatesExperiments;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.experiments.RequestToken;
import request.experiments.RequestsExperiments;

public class DeleteExperiment {

    public ValidatableResponse response;
    public ResponseCreatesExperiments responseCreatesExperiments;
    public String InvalidToken = "123";
    String token;

    @Test
    public void validateDeleteExperimentsByIdReturnStatusCode200(){
        token = RequestToken.captureToken();
        response = RequestsExperiments.deleteExperiments(RequestsExperiments.responseCreatesExperiments, token);
        response.statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void validateDeleteExperimentsByIdReturnStatusCode401(){
        response = RequestsExperiments.deleteExperiments(RequestsExperiments.responseCreatesExperiments, InvalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    @Test
    public void validateDeleteExperimentsByIdReturnStatusCode400(){
        token = RequestToken.captureToken();
        responseCreatesExperiments = new ResponseCreatesExperiments();
        response = RequestsExperiments.deleteExperiments(responseCreatesExperiments, token);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
    }

}
