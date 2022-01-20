package acceptance.datasets;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.datasets.RequestsDatasets;
import request.experiments.RequestToken;

import static org.hamcrest.CoreMatchers.notNullValue;

public class ListDatasets {

    private ValidatableResponse response;
    private String token, invalidToken;

    @Test
    public void validateGetListDatasetsReturnStatusCode200() {
        token = RequestToken.captureToken();
        response = RequestsDatasets.getListDatasets(token);
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }

    @Test
    public void validateGetListDatasetsReturnStatusCode401() {
        invalidToken = RequestToken.captureInvalidToken();
        response = RequestsDatasets.getListDatasets(invalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }

}
