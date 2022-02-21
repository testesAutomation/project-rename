package acceptance.backtest;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.backtests.RequestBackTests;
import request.token.RequestToken;

import static org.hamcrest.CoreMatchers.notNullValue;

public class GetListBackTests {

    private ValidatableResponse response;
    private String token, invalidToken;

    @Test
    public void validateGetListBackTestReturnStatusCode200()  {
        token = RequestToken.captureToken();
        response = RequestBackTests.getListBackTest(token);
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }

    @Test
    public void validateGetListBackTestReturnStatusCode401()  {
        invalidToken = RequestToken.captureInvalidToken();
        response = RequestBackTests.getListBackTest(invalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

}
