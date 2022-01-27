package acceptance.models;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.models.RequestToken;
import request.models.RequestModels;

public class DeleteModels {

    private ValidatableResponse response;
    private String token, invalidToken;

    @Test
    public void validateDeleteModelsByIdReturnStatusCode200() {
        token = RequestToken.captureToken();
        response = RequestModels.deleteModelsById(RequestModels.responseCreateModels, token);
        response.statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void validateDeleteModelsByIdReturnStatusCode401() {
        invalidToken = RequestToken.captureInvalidToken();
        response = RequestModels.deleteModelsById(RequestModels.responseCreateModels, invalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    @Test
    public void validateDeleteModelsByIdReturnStatusCode404() {

    }


}
