package acceptance.datasets;

import io.restassured.response.ValidatableResponse;
import models.datasets.BodyCreateDatasets;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.datasets.RequestsDatasets;
import request.experiments.RequestToken;

import static org.hamcrest.CoreMatchers.notNullValue;

public class CreatesDatasets {

    public ValidatableResponse response;
    public BodyCreateDatasets bodyCreateDatasets;
    String token;
    public String InvalidToken = "123";

    @Test
    public void validateCreatesDatasetsWithExperimentReturnStatusCode200()  {
        token = RequestToken.captureToken();
        response = RequestsDatasets.createsDatasetsWithExperiment(token);
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }

    @Test
    public void validateCreatesDatasetsWithoutAnyIdReturnStatusCode200() {
        token = RequestToken.captureToken();
        response = RequestsDatasets.createsDatasetWithoutAnyId(token);
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }

    @Test
    public void validateCreatesDatasetsReturnStatusCode401() {
        bodyCreateDatasets = new BodyCreateDatasets();
        response = RequestsDatasets.createsDatasetsWithExperiment(InvalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }

    @Test
    public void validateCreatesDatasetsReturnStatusCode404() {
        token = RequestToken.captureToken();
        response = RequestsDatasets.createsDatasetsWithExperiment(token);
        response.statusCode(HttpStatus.SC_NOT_FOUND);
        response.body(notNullValue());
    }


}
