package acceptance.datasets;

import io.restassured.response.ValidatableResponse;
import models.datasets.ResponseCreateDatasets;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.datasets.RequestsDatasets;
import request.experiments.RequestToken;

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
        ResponseCreateDatasets responseCreateDatasetsNotFound = new ResponseCreateDatasets();
        responseCreateDatasetsNotFound.setId("ID-NOT-FOUND");
        response = RequestsDatasets.deleteDatasetsById(responseCreateDatasetsNotFound, token);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
    }

}
