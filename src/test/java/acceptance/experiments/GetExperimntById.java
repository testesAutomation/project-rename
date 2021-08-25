package acceptance.experiments;
import io.restassured.response.ValidatableResponse;

import org.apache.http.HttpStatus;
import org.hamcrest.CoreMatchers;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import request.experiments.RequestToken;
import request.experiments.RequestsExperiments;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.notNullValue;

public class GetExperimntById {

    public ValidatableResponse response;
    public String InvalidToken = "123";
    String token;
    @Test
    public void validateListExperimentsByIdReturnStatusCode200() throws IOException, ParseException {
        token = RequestToken.captureToken();
        response = RequestsExperiments.listExperimentsById(RequestsExperiments.responseCreatesExperiments.get(0), token);
        response.statusCode(HttpStatus.SC_OK);
        response.body("id", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.get(0).getId()));
        response.body(".name", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.get(0).getName()));
        response.body("creationDate", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.get(0).getCreationDate()));
        response.body("lastUpdateDate", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.get(0).getLastUpdateDate()));
        response.body("image", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.get(0).getImage()));
        response.body("description", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.get(0).getDescription()));
        response.body("datasetCount", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.get(0).getDatasetCount()));
    }

    @Test
    public void validateListExperimentsByIdReturnStatusCode401() {
        token = InvalidToken;
        response = RequestsExperiments.listExperimentsById(RequestsExperiments.responseCreatesExperiments.get(0), token);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }
}
