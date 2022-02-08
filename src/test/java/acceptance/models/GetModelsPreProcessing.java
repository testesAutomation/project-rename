package acceptance.models;

import io.restassured.response.ValidatableResponse;
import models.models.BodyModelsColumns;
import models.models.ResponseModels;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.models.RequestModels;
import request.models.RequestToken;

import static config.Constant.INVALID_DATASET_ID;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetModelsPreProcessing {

    private ValidatableResponse response;
    private String token, invalidToken;

    @Test
    public void validateGetModelsPreProcessingReturnStatusCode200() {
        token = RequestToken.captureToken();
        response = RequestModels.getPreprocessingModels(RequestModels.responseModels, token);
        response.statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void validateGetModelsPreProcessingReturnStatusCode401() {
        invalidToken = RequestToken.captureInvalidToken();
        response = RequestModels.getPreprocessingModels(RequestModels.responseModels, invalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }

    @Test
    public void  validateGetModelsPreProcessingReturnStatusCode400() {
        token = RequestToken.captureToken();
        ResponseModels invalidResponseModels = new ResponseModels();
        invalidResponseModels.setId(INVALID_DATASET_ID.toString());
        response = RequestModels.getPreprocessingModels(invalidResponseModels, token);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
    }

}
