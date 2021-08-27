package acceptance.experiments;
import io.restassured.response.ValidatableResponse;

import org.apache.http.HttpStatus;
import org.hamcrest.CoreMatchers;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import request.experiments.RequestToken;
import request.experiments.RequestsExperiments;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.notNullValue;

public class GetExperimentById {

    public ValidatableResponse response;
    public String InvalidToken = "123";
    String token;
    @Test
    public void validateGetExperimentByIdReturnStatusCode200()  {
        token = RequestToken.captureToken();
        response = RequestsExperiments.listExperimentsById(RequestsExperiments.responseCreatesExperiments, token);
        response.statusCode(HttpStatus.SC_OK);
        response.body("id", CoreMatchers.containsString(RequestsExperiments.responseCreatesExperiments.getId()));
        response.body("name", CoreMatchers.containsString(RequestsExperiments.responseCreatesExperiments.getName()));
        response.body("creationDate", CoreMatchers.containsString(RequestsExperiments.responseCreatesExperiments.getCreationDate()));
        response.body("lastUpdateDate", CoreMatchers.containsString(RequestsExperiments.responseCreatesExperiments.getLastUpdateDate()));
        response.body("image", CoreMatchers.containsString(RequestsExperiments.responseCreatesExperiments.getImage()));
        response.body("description", CoreMatchers.containsString(RequestsExperiments.responseCreatesExperiments.getDescription()));
    }

    @Test
    public void validateGetExperimentByIdReturnStatusCode401() {
        token = InvalidToken;
        response = RequestsExperiments.listExperimentsById(RequestsExperiments.responseCreatesExperiments, token);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }
}
