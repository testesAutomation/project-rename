package acceptance.experiments;

import io.restassured.response.ValidatableResponse;
import models.experiments.ResponseCreatesExperiments;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import request.experiments.RequestToken;
import request.experiments.RequestsExperiments;

public class DeleteExperiment {

        public ValidatableResponse response;
        String token;

        @Test
        public void validateDeleteExperimentsByIdReturnStatusCode200(){
            token = RequestToken.captureToken();
            response = RequestsExperiments.deleteExperiments(RequestsExperiments.responseCreatesExperiments, token);
            response.statusCode(HttpStatus.SC_OK);
        }

    }
