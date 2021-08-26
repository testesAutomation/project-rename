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
        response.body("id", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.getId().replace("\"", "")));
        response.body("name", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.getName().replace("\"", "")));
        response.body("creationDate", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.getCreationDate().replace("\"", "")));
        response.body("lastUpdateDate", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.getLastUpdateDate().replace("\"", "")));
        response.body("image", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.getImage().replace("\"", "")));
        response.body("description", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.getDescription().replace("\"", "")));
        response.body("datasetCount", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.getDatasetCount()));
    }

    @Test
    public void validateGetExperimentByIdReturnStatusCode401() {
        token = InvalidToken;
        response = RequestsExperiments.listExperimentsById(RequestsExperiments.responseCreatesExperiments, token);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }
}
