package acceptance.backtest;

import config.Paraments;
import io.restassured.response.ValidatableResponse;
import models.backtest.ResponseBackTests;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.backtests.RequestBackTests;
import request.token.RequestToken;

public class DeleteBackTests {

    private ValidatableResponse response;
    private ResponseBackTests invalidResponseBackTests;
    private String token, invalidToken;

    @Test
    public void validateDeleteBackTestReturnStatusCode200()  {
        token = RequestToken.captureToken();
        response = RequestBackTests.deleteBackTestsById(RequestBackTests.responseBackTest, token);
        response.statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void validateDeleteBackTestReturnStatusCode401()  {
        invalidToken = RequestToken.captureInvalidToken();
        response = RequestBackTests.deleteBackTestsById(RequestBackTests.responseBackTest, invalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
    }


    @Test
    public void validateDeleteBackTestReturnStatusCode400()  {
        token = RequestToken.captureToken();
        invalidResponseBackTests = new ResponseBackTests();
        invalidResponseBackTests.setId(Paraments.INVALID_BACKTESTS_ID.toString());
        response = RequestBackTests.deleteBackTestsById(invalidResponseBackTests, token);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
