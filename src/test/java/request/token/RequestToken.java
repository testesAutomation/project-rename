package request.token;

import com.github.javafaker.Faker;
import config.Urls;
import io.restassured.http.ContentType;
import models.token.BodyToken;
import java.util.Locale;
import static io.restassured.RestAssured.given;

public class RequestToken {

    private static String token;
    private static String tokenInvalid;

    private static Faker faker;

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

    public static String captureInvalidToken() {
        faker = new Faker(new Locale("pt-BR"));
        tokenInvalid = faker.lorem().characters(6);
        return tokenInvalid;
    }
}
