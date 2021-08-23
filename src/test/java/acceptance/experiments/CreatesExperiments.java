package acceptance.experiments;


import com.fasterxml.jackson.databind.ObjectMapper;
import config.ReadAndWriteJSON;
import io.restassured.response.ValidatableResponse;
import models.BodyCreatesExperiments;
import models.ResponseCreatesExperiments;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.experiments.RequestCreatesExperiments;
import request.experiments.RequestListExperiments;
import request.experiments.RequestToken;

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
        response = RequestCreatesExperiments.createsExperiments(bodyCreatesExperiments.validBody(),token);
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
        responseCreatesExperiments = response.extract().as(ResponseCreatesExperiments.class);
        ObjectMapper Obj = new ObjectMapper();
        ReadAndWriteJSON.writeJson(Obj.writeValueAsString(responseCreatesExperiments), "Creates");
    }

    @Test
    public void validateCreatesExperimentsReturnStatusCode401() {
        bodyCreatesExperiments = new BodyCreatesExperiments();
        token = InvalidToken;
        response = RequestCreatesExperiments.createsExperiments(bodyCreatesExperiments.validBody(),token);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }

    @Test
    public void validateCreatesExperimentsReturnStatusCode400() {
        bodyCreatesExperiments = new BodyCreatesExperiments();
        token = RequestToken.captureToken();
        response = RequestCreatesExperiments.createsExperiments(bodyCreatesExperiments.invalidBody(),token);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
        response.body(notNullValue());
    }

}
