package acceptance.datasets;

import io.restassured.response.ValidatableResponse;
import models.datasets.ResponseCreateDatasets;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.datasets.RequestsDatasets;
import request.experiments.RequestToken;

import static org.hamcrest.CoreMatchers.notNullValue;

public class GetDatasetsById {

    public ValidatableResponse response;
    public ResponseCreateDatasets responseCreateDatasets;
    String token;
    public String InvalidToken = "123";

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
    public void validateGetDatasetsByIdReturnStatusCode404() {
        token = RequestToken.captureToken();
        responseCreateDatasets = RequestsDatasets.responseCreateDatasets;
        responseCreateDatasets.setId("ID-NOT-FOUND-NUMBER-333");
        response = RequestsDatasets.getDatasetsById(responseCreateDatasets, token);
        response.statusCode(HttpStatus.SC_NOT_FOUND);
        response.body(notNullValue());
    }

}
