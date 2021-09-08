package acceptance.datasets;

import io.restassured.response.ValidatableResponse;
import models.datasets.BodyCreateDatasets;
import models.experiments.BodyCreatesExperiments;
import models.experiments.ResponseCreatesExperiments;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.datasets.RequestsDatasets;
import request.experiments.RequestToken;
import request.experiments.RequestsExperiments;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.notNullValue;

public class CreatesDatasets {

    public ValidatableResponse response;
    public BodyCreateDatasets bodyCreateDatasets;
    String token;
    public String InvalidToken = "123";

    @Test
    public void validateCreatesDatasetsReturnStatusCode200()  {
        bodyCreateDatasets = new BodyCreateDatasets();
        token = RequestToken.captureToken();
        response = RequestsDatasets.createsDatasets(bodyCreateDatasets, token);
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }

}
