package acceptance.datasets;

import io.restassured.response.ValidatableResponse;
import models.datasets.ResponseCreateDatasets;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.datasets.RequestsDatasets;
import request.experiments.RequestToken;

import static org.hamcrest.CoreMatchers.notNullValue;

public class GetDatasetsById {

    private ValidatableResponse response;
    private String token;
    private String InvalidToken = "123";

    @Test
    public void validateGetDatasetsByIdReturnStatusCode200() {
        token = RequestToken.captureToken();
        response = RequestsDatasets.getDatasetsById(RequestsDatasets.responseCreateDatasets, token);
        response.statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void validateGetDatasetsByIdReturnStatusCode401() {
        token = InvalidToken;
        response = RequestsDatasets.getDatasetsById(RequestsDatasets.responseCreateDatasets, token);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }

    @Test
    public void validateGetDatasetsByIdReturnStatusCode400() {
        token = RequestToken.captureToken();
        ResponseCreateDatasets responseCreateDatasetsNotFound = new ResponseCreateDatasets();
        responseCreateDatasetsNotFound.setId("ID-NOT-FOUND");
        response = RequestsDatasets.getDatasetsById(responseCreateDatasetsNotFound, token);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
        response.body(notNullValue());
    }

}
