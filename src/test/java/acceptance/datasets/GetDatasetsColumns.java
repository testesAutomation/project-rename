package acceptance.datasets;

import io.restassured.response.ValidatableResponse;
import models.datasets.ResponseCreateDatasets;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.datasets.RequestsDatasets;
import request.experiments.RequestToken;

import static org.hamcrest.CoreMatchers.notNullValue;

public class GetDatasetsColumns {

    private ValidatableResponse response;
    private String token, invalidToken;

    @Test
    public void validateGetDatasetsColumnsReturnStatusCode200() {
        token = RequestToken.captureToken();
        response = RequestsDatasets.getDatasetsColumns(RequestsDatasets.responseCreateDatasets, token);
        response.statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void validateGetDatasetsColumnsReturnStatusCode401() {
        invalidToken = RequestToken.captureInvalidToken();
        response = RequestsDatasets.getDatasetsColumns(RequestsDatasets.responseCreateDatasets, invalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }

    @Test
    public void validateGetDatasetsColumnsReturnStatusCode400() {
        token = RequestToken.captureToken();
        ResponseCreateDatasets responseCreateDatasetsNotFound = new ResponseCreateDatasets();
        responseCreateDatasetsNotFound.setId("ID-NOT-FOUND");
        response = RequestsDatasets.getDatasetsColumns(responseCreateDatasetsNotFound, token);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
        response.body(notNullValue());
    }

}
