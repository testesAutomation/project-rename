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
    private String token;

    @Test
    public void validateCreateModelsReturnStatusCode200()  {
        token = RequestToken.captureToken();
        bodyCreateModels = new BodyCreateModels();
        response = RequestModels.createModels(bodyCreateModels.newBodyCreateModels(), token);
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }
}
