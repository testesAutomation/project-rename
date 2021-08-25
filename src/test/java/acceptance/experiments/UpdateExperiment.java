package acceptance.experiments;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.ValidatableResponse;
import models.BodyCreatesExperiments;
import models.ResponseCreatesExperiments;
import org.apache.http.HttpStatus;
import org.hamcrest.CoreMatchers;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import request.experiments.RequestToken;
import request.experiments.RequestsExperiments;

import java.io.IOException;

public class UpdateExperiment {

    public ValidatableResponse response;
    public BodyCreatesExperiments newBodyForUpdate;
    public ResponseCreatesExperiments responseCreatesExperiments;
    public String InvalidToken = "123";
    String token;

    @Test
    public void validateUpdateExperimentsByIdReturnStatusCode200() throws IOException, ParseException {
        token = RequestToken.captureToken();
        newBodyForUpdate = new BodyCreatesExperiments().validBody();
        responseCreatesExperiments = RequestsExperiments.responseCreatesExperiments;
        responseCreatesExperiments.setName(newBodyForUpdate.getName());
        response = RequestsExperiments.putExperiments(responseCreatesExperiments, token);
        response.statusCode(HttpStatus.SC_OK);
        response.body("id", CoreMatchers.hasItem(responseCreatesExperiments.getId()));
        response.body("name", CoreMatchers.hasItem(responseCreatesExperiments.getName()));
        response.body("creationDate", CoreMatchers.hasItem(responseCreatesExperiments.getCreationDate()));
        response.body("image", CoreMatchers.hasItem(responseCreatesExperiments.getImage()));
        response.body("description", CoreMatchers.hasItem(responseCreatesExperiments.getDescription()));
        response.body("datasetCount", CoreMatchers.hasItem(responseCreatesExperiments.getDatasetCount()));

    }

    @Test
    public void validateUpdateExperimentsByIdReturnStatusCode400() throws IOException, ParseException {
        token = RequestToken.captureToken();
        newBodyForUpdate = new BodyCreatesExperiments().validBody();
        responseCreatesExperiments = RequestsExperiments.responseCreatesExperiments;
        responseCreatesExperiments.setName("");
        response = RequestsExperiments.putExperiments(responseCreatesExperiments, token);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);

    }

    @Test
    public void validateUpdateExperimentsByIdReturnStatusCode401()  {
        responseCreatesExperiments = RequestsExperiments.responseCreatesExperiments;
        response = RequestsExperiments.putExperiments(responseCreatesExperiments, InvalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);

    }

}
