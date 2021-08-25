package acceptance.experiments;

import io.restassured.response.ValidatableResponse;
import models.BodyCreatesExperiments;
import models.ResponseCreatesExperiments;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.experiments.RequestToken;
import request.experiments.RequestsExperiments;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.notNullValue;

public class CreatesExperiments {

    public ValidatableResponse response;
    public BodyCreatesExperiments bodyCreatesExperiments;
    public ResponseCreatesExperiments responseCreatesExperiments;
    String token;
    public String InvalidToken = "123";

    @Test
    public void validateCreatesExperimentsReturnStatusCode200() throws IOException {
        bodyCreatesExperiments = new BodyCreatesExperiments();
        token = RequestToken.captureToken();
        response = RequestsExperiments.createsExperiments(bodyCreatesExperiments.validBody(),token);
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }

    @Test
    public void validateCreatesExperimentsReturnStatusCode401() {
        bodyCreatesExperiments = new BodyCreatesExperiments();
        token = InvalidToken;
        response = RequestsExperiments.createsExperiments(bodyCreatesExperiments.validBody(),token);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }

    @Test
    public void validateCreatesExperimentsReturnStatusCode400() {
        bodyCreatesExperiments = new BodyCreatesExperiments();
        token = RequestToken.captureToken();
        response = RequestsExperiments.createsExperiments(bodyCreatesExperiments.invalidBody(),token);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
        response.body(notNullValue());
    }

}
