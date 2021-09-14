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

    public ValidatableResponse response;
    public BodyCreateDatasets bodyCreateDatasets;
    public BodyCreatesExperiments bodyCreatesExperiments;
    String token;
    public String InvalidToken = "123";
    public File file, fileRandomFor404;

    @BeforeTest
    public void filePathSet(){
        file = new File("src/test/resources/dataset_example.csv");
        fileRandomFor404 = new File("src/test/resources/datasetVazio.csv");
    }

    @Test
    public void validateCreatesDatasetsWithExperimentReturnStatusCode200()  {
        token = RequestToken.captureToken();
        bodyCreatesExperiments = new BodyCreatesExperiments();
        response = RequestsExperiments.createsExperiments(bodyCreatesExperiments.validBody(),token);
        response = RequestsDatasets.createsDatasetsWithExperiment(RequestsExperiments.responseCreatesExperiments, token, file);
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }

    @Test
    public void validateCreatesDatasetsWithoutAnyIdReturnStatusCode200() {
        token = RequestToken.captureToken();
        response = RequestsDatasets.createsDatasetWithoutAnyId(token, file);
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }

    @Test
    public void validateCreatesDatasetsReturnStatusCode401() {
        token = RequestToken.captureToken();
        bodyCreatesExperiments = new BodyCreatesExperiments();
        response = RequestsExperiments.createsExperiments(bodyCreatesExperiments.validBody(),token);
        response = RequestsDatasets.createsDatasetsWithExperiment(RequestsExperiments.responseCreatesExperiments, InvalidToken, file);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }

    @Test
    public void validateCreatesDatasetsReturnStatusCode400() {
            token = RequestToken.captureToken();
            ResponseCreatesExperiments responseCreatesExperimentsEmpty = new ResponseCreatesExperiments();
            responseCreatesExperimentsEmpty.setId("");
            response = RequestsDatasets.createsDatasetsWithExperiment(responseCreatesExperimentsEmpty, token, fileRandomFor404);
            response.statusCode(HttpStatus.SC_BAD_REQUEST);
            response.body(notNullValue());
    }


}
