package acceptance.backtest;

import config.Paraments;
import io.restassured.response.ValidatableResponse;
import models.backtest.ResponseBackTests;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.backtests.RequestBackTests;
import request.token.RequestToken;

import static org.hamcrest.CoreMatchers.notNullValue;

public class GetBackTestsById {

    private ValidatableResponse response;
    private String token, invalidToken;

    @Test
    public void validateGetBackTestByIdReturnStatusCode200()  {
        token = RequestToken.captureToken();
        response = RequestBackTests.getBackTestsById(RequestBackTests.responseBackTest, token);
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }

    @Test
    public void validateGetBackTestByIdReturnStatusCode401()  {
        invalidToken = RequestToken.captureInvalidToken();
        response = RequestBackTests.getBackTestsById(RequestBackTests.responseBackTest, invalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    @Test
    public void validateGetBackTestByIdReturnStatusCode400()  {
        token = RequestToken.captureToken();
        ResponseBackTests invalidRequest = new ResponseBackTests();
        invalidRequest.setId(Paraments.INVALID_BACKTESTS_ID.toString());
        response = RequestBackTests.getBackTestsById(invalidRequest, token);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
    }

}
