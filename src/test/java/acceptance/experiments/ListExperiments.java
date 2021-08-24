package acceptance.experiments;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.ReadAndWriteJSON;
import io.restassured.response.ValidatableResponse;
import models.BodyListExperiments;
import models.ResponseCreatesExperiments;
import models.ResponseListExperiment;
import org.apache.http.HttpStatus;
import org.json.simple.parser.ParseException;
import org.junit.FixMethodOrder;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.junit.runners.MethodSorters;
import request.experiments.RequestListExperiments;
import request.experiments.RequestToken;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ListExperiments {

    public ValidatableResponse response;
    public BodyListExperiments bodyListExperiments;
    public List<ResponseListExperiment> responseListExperiment;
    public List<String> returnListAllIdExperiments, returnListAllNamesExperiments;
    public ResponseCreatesExperiments responseCreatesExperiments;
    public String InvalidToken = "123";
    String token;

    @Test
    public void validateListExperimentsReturnStatusCode200() throws IOException, ParseException {
        bodyListExperiments = new BodyListExperiments();
        ObjectMapper objectMapper = new ObjectMapper();
        token = RequestToken.captureToken();
        response = RequestListExperiments.listExperiments(token);
        response.statusCode(HttpStatus.SC_OK);
        returnListAllIdExperiments = response.extract().jsonPath().getList("id");
        returnListAllNamesExperiments = response.extract().jsonPath().getList("name");
        responseCreatesExperiments  = objectMapper.readValue(ReadAndWriteJSON.readJson("Creates"), ResponseCreatesExperiments.class);
        Assert.assertEquals(returnListAllIdExperiments.contains(responseCreatesExperiments.getId()), true);
        Assert.assertEquals(returnListAllNamesExperiments.contains(responseCreatesExperiments.getName()), true);

    }

    @Test
    public void validateListExperimentsReturnStatusCode401() {
        bodyListExperiments = new BodyListExperiments();
        response = RequestListExperiments.listExperiments(InvalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
    }


}

