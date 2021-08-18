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
    public void validateListExperimentsReturnStatusCode401() {
        bodyListExperiments = new BodyListExperiments();
        token = InvalidToken;
        response = RequestListExperiments.listExperiments(bodyListExperiments.getListExperimentValid(),token);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    @Test
    public void validateListExperimentsReturnStatusCode400() {
        bodyListExperiments = new BodyListExperiments();
        token = RequestToken.captureToken();
        response = RequestListExperiments.listExperiments(bodyListExperiments.getListExperimentsInvalid(),token);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
        response.body(notNullValue());
    }

}

