package acceptance.models;

import io.restassured.response.ValidatableResponse;
import models.models.BodyModelsColumns;
import models.models.ResponseModels;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.models.RequestModels;
import request.models.RequestToken;

import static config.Constant.INVALID_DATASET_ID;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetModelsColumns {

    private ValidatableResponse response;
    private String token, invalidToken;

    @Test
    public void validateGetModelsColumnsReturnStatusCode200() {
        token = RequestToken.captureToken();
        BodyModelsColumns bodyModelsColumns = new BodyModelsColumns();
        response = RequestModels.getModelsColumns(RequestModels.responseModels, bodyModelsColumns, token);
        response.statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void validateGetModelsColumnsReturnStatusCode401() {
        invalidToken = RequestToken.captureInvalidToken();
        BodyModelsColumns bodyModelsColumns = new BodyModelsColumns();
        response = RequestModels.getModelsColumns(RequestModels.responseModels, bodyModelsColumns, invalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }


    @Test
    public void  validateGetModelsColumnsReturnStatusCode400() {
        token = RequestToken.captureToken();
        ResponseModels invalidResponseModels = new ResponseModels();
        BodyModelsColumns bodyModelsColumns = new BodyModelsColumns();
        invalidResponseModels.setId(INVALID_DATASET_ID.toString());
        response = RequestModels.getModelsColumns(invalidResponseModels, bodyModelsColumns, token);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
    }

}
