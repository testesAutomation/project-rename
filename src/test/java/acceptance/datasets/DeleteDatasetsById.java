package acceptance.datasets;

import io.restassured.response.ValidatableResponse;
import models.datasets.ResponseCreateDatasets;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.datasets.RequestsDatasets;
import request.experiments.RequestToken;

import static org.hamcrest.CoreMatchers.notNullValue;

public class DeleteDatasetsById {

    public ValidatableResponse response;
    public ResponseCreateDatasets responseCreateDatasets;
    String token;
    public String InvalidToken = "123";

    @Test
    public void validateDeleteDatasetsByIdReturnStatusCode200() {
        token = RequestToken.captureToken();
        response = RequestsDatasets.deleteDatasetsById(RequestsDatasets.responseCreateDatasets, token);
        response.statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void validateDeleteDatasetsByIdReturnStatusCode401() {
        token = InvalidToken;
        response = RequestsDatasets.deleteDatasetsById(RequestsDatasets.responseCreateDatasets, token);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    @Test
    public void validateDeleteDatasetsByIdReturnStatusCode404() {
        token = RequestToken.captureToken();
        responseCreateDatasets = RequestsDatasets.responseCreateDatasets;
        responseCreateDatasets.setId("ID-NOT-FOUND-NUMBER-333");
        response = RequestsDatasets.deleteDatasetsById(responseCreateDatasets, token);
        response.statusCode(HttpStatus.SC_NOT_FOUND);
    }

}
