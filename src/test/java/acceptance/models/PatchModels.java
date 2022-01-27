package acceptance.models;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.models.RequestModels;
import request.models.RequestToken;

import static config.Constant.NAMEUPDATED;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public class PatchModels {

    private ValidatableResponse response;
    private String token, invalidToken;

    @Test
    public void validatePatchModelsReturnStatusCode200() {
        token = RequestToken.captureToken();
        response = RequestModels.pathModels(RequestModels.responseModels, token, NAMEUPDATED.toString());
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
        response.body("name", is(NAMEUPDATED.toString()));
    }

    @Test
    public void validatePatchModelsReturnStatusCode401() {
        invalidToken = RequestToken.captureInvalidToken();
        response = RequestModels.pathModels(RequestModels.responseModels, invalidToken, NAMEUPDATED.toString());
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());

    }

    @Test
    public void validatePatchModelsReturnStatusCode400() {
        token = RequestToken.captureToken();
        response = RequestModels.pathModels(RequestModels.responseModels, token, "");
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
        response.body(notNullValue());

    }

}
