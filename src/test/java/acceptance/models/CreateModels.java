package acceptance.models;

import io.restassured.response.ValidatableResponse;
import models.models.BodyCreateModels;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.models.RequestToken;
import request.models.RequestModels;

import static org.hamcrest.CoreMatchers.notNullValue;

public class CreateModels {

    private ValidatableResponse response;
    private BodyCreateModels bodyCreateModels;
    private String token, invalidToken;

    @Test
    public void validateCreateModelsReturnStatusCode200()  {
        token = RequestToken.captureToken();
        bodyCreateModels = new BodyCreateModels();
        response = RequestModels.createModels(bodyCreateModels.newBodyCreateModels(), token);
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }

    @Test
    public void validateCreateModelsReturnStatusCode401()  {
        invalidToken = RequestToken.captureInvalidToken();
        bodyCreateModels = new BodyCreateModels();
        response = RequestModels.createModels(bodyCreateModels.newBodyCreateModels(), invalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }

    @Test
    public void validateCreateModelsReturnStatusCode400() {
        token = RequestToken.captureToken();
        BodyCreateModels invalidBodyCreateModels = new BodyCreateModels();
        invalidBodyCreateModels.newBodyCreateModels();
        invalidBodyCreateModels.setDatasetId("");
        response = RequestModels.createModels(invalidBodyCreateModels, token);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
        response.body(notNullValue());

    }
}
