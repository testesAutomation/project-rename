package request.datasets;

import com.github.javafaker.Faker;
import com.google.common.net.MediaType;
import config.Headers;
import config.Urls;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.datasets.BodyCreateDatasets;
import models.datasets.ResponseCreateDatasets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

import static io.restassured.RestAssured.given;

public class RequestsDatasets {

    private static String path = "/datasets";
    static ValidatableResponse response;
    public static ResponseCreateDatasets responseCreateDatasets, updateResponseCreateDatasets;

    public static ValidatableResponse createsDatasets(BodyCreateDatasets bodyCreateDatasets, String token) {

        response =  given()
                .log()
                .all()
                .contentType("multipart/form-data")
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .body(bodyCreateDatasets)
                .post(Urls.ROOT_EXPERIMENTS.getUrl() + path)
                .then()
                .log().all();

        if(response.extract().statusCode() == 200) {
            responseCreateDatasets = response.extract().as(ResponseCreateDatasets.class);
        }
        return response;
    }

    public static ValidatableResponse getDatasetsById(ResponseCreateDatasets responseCreateDatasets, String token) {

        response =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .get(Urls.ROOT_EXPERIMENTS.getUrl() + path + "/" + responseCreateDatasets.getId())
                .then()
                .log().all();
        return response;
    }

    public static ValidatableResponse deleteDatasetsById(ResponseCreateDatasets responseCreateDatasets, String token) {

        response =   given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .delete(Urls.ROOT_EXPERIMENTS.getUrl() + path + "/" + responseCreateDatasets.getId())
                .then()
                .log().all();
        return response;
    }

    public static ValidatableResponse patchDatasetsById(ResponseCreateDatasets responseCreateDatasets, String token) {
        BodyCreateDatasets updateBodyCreateDatasets = new BodyCreateDatasets();
        Faker faker = new Faker(new Locale("pt-BR"));
        responseCreateDatasets.setName(updateBodyCreateDatasets.getName());
        responseCreateDatasets.setDefaultTarget(responseCreateDatasets.getDefaultTarget() + faker.number().randomNumber());

        String bodyPatch = "{\n" +
                "  \"name\": \""+ responseCreateDatasets.getName() +"\",\n" +
                "  \"defaultTarget\": \""+responseCreateDatasets.getDefaultTarget()+"\"\n" +
                "}";


        response =   given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .header(Headers.AUTHORIZATION.getHeader(), Headers.BEARER.getHeader()+ token)
                .body(bodyPatch)
                .patch(Urls.ROOT_EXPERIMENTS.getUrl() + path + "/" + responseCreateDatasets.getId())
                .then()
                .log().all();
        return response;
    }


}
