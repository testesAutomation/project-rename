package acceptance.experiments;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.ValidatableResponse;
import models.BodyListExperiments;
import models.ResponseCreatesExperiments;
import models.ResponseListExperiment;
import org.apache.http.HttpStatus;
import org.hamcrest.CoreMatchers;
import org.json.simple.parser.ParseException;
import org.junit.FixMethodOrder;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.junit.runners.MethodSorters;
import request.experiments.RequestToken;
import request.experiments.RequestsExperiments;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ListExperiments {

    public ValidatableResponse response;
    public BodyListExperiments bodyListExperiments;
    public String InvalidToken = "123";
    String token;

    @Test
    public void validateListExperimentsReturnStatusCode200() throws IOException, ParseException {
        token = RequestToken.captureToken();
        response = RequestsExperiments.listExperiments(token);
        response.statusCode(HttpStatus.SC_OK);
        response.body("items.id", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.get(0).getId()));
        response.body("items.name", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.get(0).getName()));
        response.body("items.creationDate", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.get(0).getCreationDate()));
        response.body("items.lastUpdateDate", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.get(0).getLastUpdateDate()));
        response.body("items.image", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.get(0).getImage()));
        response.body("items.description", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.get(0).getDescription()));
        response.body("items.datasetCount", CoreMatchers.hasItem(RequestsExperiments.responseCreatesExperiments.get(0).getDatasetCount()));

    }

    @Test
    public void validateListExperimentsReturnStatusCode401() {
        bodyListExperiments = new BodyListExperiments();
        response = RequestsExperiments.listExperiments(InvalidToken);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
    }


}

