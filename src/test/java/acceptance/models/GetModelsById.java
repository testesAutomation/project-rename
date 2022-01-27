package acceptance.models;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.models.RequestToken;
import request.models.RequestModels;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetModelsById {

    private ValidatableResponse response;
    private String token, invalidToken;

    @Test
    public void validateGetModelsByIdReturnStatusCode200() {
        token = RequestToken.captureToken();
        response = RequestModels.getModelsById(RequestModels.responseCreateModels, token);
        response.statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void validateGetModelsByIdReturnStatusCode401() {
        invalidToken = RequestToken.captureInvalidToken();
        response = RequestModels.getModelsById(RequestModels.responseCreateModels, invalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }

    @Test
    public void validateGetModelsByIdReturnStatusCode400() {

    }


}
