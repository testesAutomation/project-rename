package acceptance.backtest;

import io.restassured.response.ValidatableResponse;
import models.backtest.BodyPutBackTests;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.backtests.RequestBackTests;
import request.token.RequestToken;

public class PutBackTests {

    private ValidatableResponse response;
    private BodyPutBackTests bodyPutBackTests, invalidBody;
    private String token, invalidToken;

    @Test
    public void validatePutBackTestReturnStatusCode200()  {
        token = RequestToken.captureToken();
        bodyPutBackTests = new BodyPutBackTests();
        response = RequestBackTests.putBackTestsById(bodyPutBackTests, token);
        response.statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void validatePutBackTestReturnStatusCode401()  {
        invalidToken = RequestToken.captureInvalidToken();
        bodyPutBackTests = new BodyPutBackTests();
        response = RequestBackTests.putBackTestsById(bodyPutBackTests, invalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    @Test
    public void validatePutBackTestReturnStatusCode400()  {
        token = RequestToken.captureToken();
        invalidBody = new BodyPutBackTests().invalidBody();
        response = RequestBackTests.putBackTestsById(invalidBody, token);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
    }

}
