package acceptance.experiments;
import io.restassured.response.ValidatableResponse;
import models.BodyListExperiments;
import models.ResponseCreatesExperiments;
import models.ResponseListExperiment;
import org.apache.http.HttpStatus;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import request.experiments.RequestListExperiments;
import request.experiments.RequestToken;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ListExperiments {

    public ValidatableResponse response;
    public BodyListExperiments bodyListExperiments;
    public List<ResponseListExperiment> responseListExperiment;
    public String InvalidToken = "123";
    String token;

    @Test
    public void validateListExperimentsReturnStatusCode200() {
        bodyListExperiments = new BodyListExperiments();
        token = RequestToken.captureToken();
        response = RequestListExperiments.listExperiments(token);
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
        response.assertThat().extract().jsonPath().get("id")
                .equals(RequestListExperiments.responseCreatesExperimentsReturn.getId());
        response.assertThat().extract().jsonPath().get("name")
                .equals(RequestListExperiments.responseCreatesExperimentsReturn.getName());
    }

    @Test
    public void validateListExperimentsReturnStatusCode401() {
        bodyListExperiments = new BodyListExperiments();
        token = InvalidToken;
        response = RequestListExperiments.listExperiments(token);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    @Test
    public void validateListExperimentsReturnStatusCode400() {
        bodyListExperiments = new BodyListExperiments();
        token = RequestToken.captureToken();
        response = RequestListExperiments.listExperiments(token);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
        response.body(notNullValue());
    }

}

