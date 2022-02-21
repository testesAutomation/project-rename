package acceptance.models;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.token.RequestToken;
import request.models.RequestModels;

public class DeleteModels {

    private ValidatableResponse response;
    private String token;

    @Test
    public void validateDeleteModelsByIdReturnStatusCode200() {
       token = RequestToken.captureToken();
       response = RequestModels.deleteModelsById(RequestModels.responseModels, token);
       response.statusCode(HttpStatus.SC_OK);
       
    }

}
