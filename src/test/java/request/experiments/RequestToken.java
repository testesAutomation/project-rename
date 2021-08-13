package request.experiments;

import config.Token;
import config.Urls;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class RequestToken {

    private static String token;

    public static String captureToken() {

        token =  given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .param("client_id", Token.client_id.getAuth())
                .param("client_secret", Token.client_secret.getAuth())
                .param("grant_type", Token.grant_type.getAuth())
                .param("scope", Token.scope.getAuth())
                .when()
                .post(Urls.TOKEN.getUrl())
                .then()
                .extract().path("accessToken");
        return token;

    }
}
