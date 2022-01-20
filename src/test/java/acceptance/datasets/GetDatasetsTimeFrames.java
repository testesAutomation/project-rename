package acceptance.datasets;

import io.restassured.response.ValidatableResponse;
import models.datasets.ResponseCreateDatasets;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.datasets.RequestsDatasets;
import request.experiments.RequestToken;

import static org.hamcrest.CoreMatchers.notNullValue;

public class GetDatasetsTimeFrames {

    private ValidatableResponse response;
    private String token, invalidToken;

    @Test
    public void validateGetDatasetsTimeframesReturnStatusCode200() {
        token = RequestToken.captureToken();
        response = RequestsDatasets.getDatasetsTimeframes(RequestsDatasets.responseCreateDatasets, token);
        response.statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void validateGetDatasetsTimeframesReturnStatusCode401() {
        invalidToken = RequestToken.captureInvalidToken();
        response = RequestsDatasets.getDatasetsTimeframes(RequestsDatasets.responseCreateDatasets, invalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }

    @Test
    public void validateGetDatasetsTimeframesReturnStatusCode400() {
        token = RequestToken.captureToken();
        ResponseCreateDatasets responseCreateDatasetsNotFound = new ResponseCreateDatasets();
        responseCreateDatasetsNotFound.setId("ID-NOT-FOUND");
        response = RequestsDatasets.getDatasetsTimeframes(responseCreateDatasetsNotFound, token);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
        response.body(notNullValue());
    }

}
