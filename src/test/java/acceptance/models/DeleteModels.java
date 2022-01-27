package acceptance.models;

import io.restassured.response.ValidatableResponse;
import models.models.ResponseModels;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.models.RequestToken;
import request.models.RequestModels;

import static config.Constant.INVALID_DATASET_ID;

public class DeleteModels {

    private ValidatableResponse response;
    private String token, invalidToken;

    @Test
    public void validateDeleteModelsByIdReturnStatusCode200() {
       token = RequestToken.captureToken();
       response = RequestModels.deleteModelsById(RequestModels.responseModels, token);
       response.statusCode(HttpStatus.SC_OK);
       
    }

    @Test
    public void validateDeleteModelsByIdReturnStatusCode401() {
      invalidToken = RequestToken.captureInvalidToken();
      response = RequestModels.deleteModelsById(RequestModels.responseModels, invalidToken);
      response.statusCode(HttpStatus.SC_UNAUTHORIZED);

    }

    @Test
    public void validateDeleteModelsByIdReturnStatusCode404() {
        token = RequestToken.captureToken();
        ResponseModels invalidResponseModels = new ResponseModels();
        invalidResponseModels.setId(INVALID_DATASET_ID.toString());
        response = RequestModels.deleteModelsById(invalidResponseModels, token);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);

    }


}
