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

    @Test
    public void validateCreatesExperimentsReturnStatusCode200() {
        bodyCreatesExperiments = new BodyCreatesExperiments();
        token = RequestToken.captureToken();
        response = RequestCreatesExperiments.createsExperiments(bodyCreatesExperiments,token);
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }




}
