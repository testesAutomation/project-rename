package acceptance.experiments;
import io.restassured.response.ValidatableResponse;
import models.BodyListExperiments;
import org.apache.http.HttpStatus;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import request.experiments.RequestListExperiments;
import request.experiments.RequestToken;

import static org.hamcrest.CoreMatchers.notNullValue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ListExperiments {

    public ValidatableResponse response;
    public BodyListExperiments bodyListExperiments;
    public String InvalidToken = "123";
    String token;

    @Test
    public void validateListExperimentsReturnStatusCode200() {
        bodyListExperiments = new BodyListExperiments();
        token = RequestToken.captureToken();
        response = RequestListExperiments.listExperiments(bodyListExperiments.getListExperimentValid(),token);
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }

    @Test
    public void validateListExperimentsReturnUnauthorized() {
        bodyListExperiments = new BodyListExperiments();
        token = InvalidToken;
        response = RequestListExperiments.listExperiments(bodyListExperiments.getListExperimentsInvalid(),token);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body("title", notNullValue());
    }

    @Test
    public void validateListExperimentsReturnStatusCode404() {
        bodyListExperiments = new BodyListExperiments();
        token = RequestToken.captureToken();
        response = RequestListExperiments.listExperiments(bodyListExperiments.getListExperimentsInvalid(),token);
        response.statusCode(HttpStatus.SC_NOT_FOUND);
        response.body(notNullValue());
    }

    @Test
    public void validateListExperimentsReturnErrorMensage() {
        bodyListExperiments = new BodyListExperiments();
        token = RequestToken.captureToken();
        response = RequestListExperiments.listExperiments(bodyListExperiments.getListExperimentsInvalid(),token);
        response.statusCode(HttpStatus.SC_OK);
        response.body("title", notNullValue());
    }


}

