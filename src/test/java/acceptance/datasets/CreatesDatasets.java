package acceptance.datasets;

import io.restassured.response.ValidatableResponse;
import models.datasets.BodyCreateDatasets;
import models.experiments.BodyCreatesExperiments;
import models.experiments.ResponseCreatesExperiments;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import request.datasets.RequestsDatasets;
import request.experiments.RequestToken;
import request.experiments.RequestsExperiments;

import java.io.File;

import static org.hamcrest.CoreMatchers.notNullValue;

public class CreatesDatasets {

    private ValidatableResponse response;
    private BodyCreatesExperiments bodyCreatesExperiments;
    private String token, invalidToken;
    private File file, fileRandomFor404;

    @BeforeTest
    public void filePathSet(){
        file = new File("src/test/resources/dataset_example.csv");
        fileRandomFor404 = new File("src/test/resources/datasetVazio.csv");
    }

    @Test
    public void validateCreatesDatasetsReturnStatusCode200()  {
        token = RequestToken.captureToken();
        bodyCreatesExperiments = new BodyCreatesExperiments();
        response = RequestsExperiments.createsExperiments(bodyCreatesExperiments.validBody(),token);
        response = RequestsDatasets.createDatasets(RequestsExperiments.responseCreatesExperiments, token, file);
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }

    @Test
    public void validateCreatesDatasetsReturnStatusCode401() {
        token = RequestToken.captureToken();
        invalidToken = RequestToken.captureInvalidToken();
        bodyCreatesExperiments = new BodyCreatesExperiments();
        response = RequestsExperiments.createsExperiments(bodyCreatesExperiments.validBody(),token);
        response = RequestsDatasets.createDatasets(RequestsExperiments.responseCreatesExperiments, invalidToken, file);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }

    @Test
    public void validateCreatesDatasetsReturnStatusCode400() {
        token = RequestToken.captureToken();
        ResponseCreatesExperiments responseCreatesExperimentsEmpty = new ResponseCreatesExperiments();
        responseCreatesExperimentsEmpty.setId("");
        response = RequestsDatasets.createDatasets(responseCreatesExperimentsEmpty, token, fileRandomFor404);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
        response.body(notNullValue());
    }


}
