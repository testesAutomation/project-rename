package acceptance.datasets;

import com.github.javafaker.Faker;
import io.restassured.response.ValidatableResponse;
import models.datasets.ResponseCreateDatasets;
import org.apache.http.HttpStatus;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import request.datasets.RequestsDatasets;
import request.experiments.RequestToken;

import java.util.Locale;

import static org.hamcrest.CoreMatchers.notNullValue;

public class PatchDatasetsById {

    public ValidatableResponse response;
    public ResponseCreateDatasets responseCreateDatasets;
    String token;
    public String InvalidToken = "123";
    String bodyPatch, nameUpdated;

    @BeforeTest
    public void init(){
    Faker faker = new Faker(new Locale("pt-BR"));
    nameUpdated = "Automação" + faker.lorem().characters(9);
    bodyPatch = "{\n" +
            "  \"name\": \""+ RequestsDatasets.responseCreateDatasets.getName() + "\",\n" +
            "  \"name\": \""+ nameUpdated +"\"\n" +
            "}";
    }

    @Test
    public void validatePatchDatasetsByIdReturnStatusCode200() {
        token = RequestToken.captureToken();
        response = RequestsDatasets.patchDatasetsById(RequestsDatasets.responseCreateDatasets, token, bodyPatch);
        response.statusCode(HttpStatus.SC_OK);
        response.body("name", CoreMatchers.containsString(nameUpdated));
    }

    @Test
    public void validatePatchDatasetsByIdReturnStatusCode401() {
        token = InvalidToken;
        response = RequestsDatasets.patchDatasetsById(RequestsDatasets.responseCreateDatasets, token, bodyPatch);
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
        response.body(notNullValue());
    }

    @Test
    public void validatePatchDatasetsByIdReturnStatusCode400() {
        token = RequestToken.captureToken();
        ResponseCreateDatasets responseCreateDatasetsNotFound = new ResponseCreateDatasets();
        responseCreateDatasetsNotFound.setId("ID-NOT-FOUND");
        response = RequestsDatasets.patchDatasetsById(responseCreateDatasetsNotFound, token, bodyPatch);
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
        response.body(notNullValue());
    }

}
