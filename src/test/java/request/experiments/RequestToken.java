package request.experiments;

import config.Urls;
import io.restassured.http.ContentType;
import models.BodyToken;

import static io.restassured.RestAssured.given;

public class RequestToken {

    private static String token;

    public static String captureToken() {
        BodyToken bodyToken = new BodyToken();

        token =  given()
                .log()
                .all()
                .contentType(ContentType.URLENC)
                .formParam("client_id", bodyToken.getClient_id())
                .formParam("client_secret", bodyToken.getClient_secret())
                .formParam("grant_type", bodyToken.getGrant_type())
                .formParam("scope", bodyToken.getScope())
                .when()
                .post(Urls.TOKEN.getUrl())
                .then()
                .extract().path("access_token");
        return token;

    }
}
