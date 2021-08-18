package acceptance.experiments;


import io.restassured.response.ValidatableResponse;
import models.BodyCreatesExperiments;
import models.BodyListExperiments;
import org.apache.http.HttpStatus;
import org.junit.Test;
import request.experiments.RequestCreatesExperiments;
import request.experiments.RequestListExperiments;
import request.experiments.RequestToken;

import static org.hamcrest.CoreMatchers.notNullValue;

public class CreatesExperiments {

    public ValidatableResponse response;
    public BodyCreatesExperiments bodyCreatesExperiments;
    String token;
    public String InvalidToken = "123";


    @Test
    public void validateCreatesExperimentsReturnStatusCode200() {
        bodyCreatesExperiments = new BodyCreatesExperiments();
        token = RequestToken.captureToken();
        response = RequestCreatesExperiments.createsExperiments(bodyCreatesExperiments.getValidBody(),token);
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }

    @Test
    public void validateCreatesExperimentsReturnStatusCode401() {
        bodyCreatesExperiments = new BodyCreatesExperiments();
        token = InvalidToken;
        response = RequestCreatesExperiments.createsExperiments(bodyCreatesExperiments.getValidBody(),token);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }

    @Test
    public void validateCreatesExperimentsReturnStatusCode400() {
        bodyCreatesExperiments = new BodyCreatesExperiments();
        token = RequestToken.captureToken();
        response = RequestCreatesExperiments.createsExperiments(bodyCreatesExperiments.getInvalidBody(),token);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
        response.body(notNullValue());
    }



}
