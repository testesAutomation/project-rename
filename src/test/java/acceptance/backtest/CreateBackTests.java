package acceptance.backtest;

import io.restassured.response.ValidatableResponse;
import models.backtest.BodyCreateBackTests;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.RequestBackTest.RequestBackTests;
import request.models.RequestModels;
import request.token.RequestToken;

import static org.hamcrest.CoreMatchers.notNullValue;

public class CreateBackTests {

    private ValidatableResponse response;
    private BodyCreateBackTests bodyCreateBackTest, invalidBody;
    private String token, invalidToken;

    @Test
    public void validateCreateBackTestReturnStatusCode200()  {
        token = RequestToken.captureToken();
        bodyCreateBackTest = new BodyCreateBackTests().validBody(RequestModels.responseModels);
        response = RequestBackTests.createBackTest(bodyCreateBackTest, token);
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }

    @Test
    public void validateCreateBackTestReturnStatusCode401()  {
        invalidToken = RequestToken.captureInvalidToken();
        bodyCreateBackTest = new BodyCreateBackTests().validBody(RequestModels.responseModels);
        response = RequestBackTests.createBackTest(bodyCreateBackTest, invalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    @Test
    public void validateCreateBackTestReturnStatusCode400()  {
        token = RequestToken.captureToken();
        invalidBody = new BodyCreateBackTests().invalidBody();
        response = RequestBackTests.createBackTest(invalidBody, token);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
    }
}



