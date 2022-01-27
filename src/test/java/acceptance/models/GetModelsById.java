package acceptance.models;

import io.restassured.response.ValidatableResponse;
import models.models.ResponseModels;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.models.RequestToken;
import request.models.RequestModels;

import static config.Constant.INVALID_DATASET_ID;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetModelsById {

    private ValidatableResponse response;
    private String token, invalidToken;

    @Test
    public void validateGetModelsByIdReturnStatusCode200() {
        token = RequestToken.captureToken();
        response = RequestModels.getModelsById(RequestModels.responseModels, token);
        response.statusCode(HttpStatus.SC_OK);
        response.body("id", is(RequestModels.responseModels.getId()));
    }

    @Test
    public void validateGetModelsByIdReturnStatusCode401() {
        invalidToken = RequestToken.captureInvalidToken();
        response = RequestModels.getModelsById(RequestModels.responseModels, invalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }

    @Test
    public void validateGetModelsByIdReturnStatusCode400() {
        token = RequestToken.captureToken();
        ResponseModels invalidResponseModels = new ResponseModels();
        invalidResponseModels.setId(INVALID_DATASET_ID.toString());
        response = RequestModels.getModelsById(invalidResponseModels, token);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
    }


}
