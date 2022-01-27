package acceptance.models;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.models.RequestToken;
import request.models.RequestModels;

import static org.hamcrest.CoreMatchers.notNullValue;

public class ListModels {

    private ValidatableResponse response;
    private String token, invalidToken;

    @Test
    public void validateGetListModelsReturnStatusCode200() {
        token = RequestToken.captureToken();
        response = RequestModels.getListModels(token);
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }

    @Test
    public void validateGetListModelsReturnStatusCode401() {
        invalidToken = RequestToken.captureInvalidToken();
        response = RequestModels.getListModels(invalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }


}
