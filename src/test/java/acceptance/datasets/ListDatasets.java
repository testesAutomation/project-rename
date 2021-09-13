package acceptance.datasets;

import io.restassured.response.ValidatableResponse;
import models.datasets.ResponseCreateDatasets;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.datasets.RequestsDatasets;
import request.experiments.RequestToken;

import static org.hamcrest.CoreMatchers.notNullValue;

public class ListDatasets {

    public ValidatableResponse response;
    public ResponseCreateDatasets responseCreateDatasets;
    String token;
    public String InvalidToken = "123";

    @Test
    public void validateGetListDatasetsReturnStatusCode200() {
        token = RequestToken.captureToken();
        response = RequestsDatasets.getListDatasets(token);
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }

    @Test
    public void validateGetListDatasetsReturnStatusCode401() {
        response = RequestsDatasets.getListDatasets(InvalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }

}
