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
    public void validateUpdateExperimentsByIdReturnStatusCode200()  {
        token = RequestToken.captureToken();
        newBodyForUpdate = new BodyCreatesExperiments().validBody();
        responseCreatesExperiments = RequestsExperiments.responseCreatesExperiments;
        responseCreatesExperiments.setName(newBodyForUpdate.getName());
        response = RequestsExperiments.putExperiments(responseCreatesExperiments, token);
        response.statusCode(HttpStatus.SC_OK);
        response.body("name", CoreMatchers.containsString(responseCreatesExperiments.getName()));
        response.body("creationDate", CoreMatchers.containsString(responseCreatesExperiments.getCreationDate()));
        response.body("image", CoreMatchers.containsString(responseCreatesExperiments.getImage()));
        response.body("description", CoreMatchers.containsString(responseCreatesExperiments.getDescription()));
    }

    @Test
    public void validateUpdateExperimentsByIdReturnStatusCode400()  {
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
