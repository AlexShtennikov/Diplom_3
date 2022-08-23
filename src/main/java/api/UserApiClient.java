package api;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_ACCEPTED;

public class UserApiClient {

    RequestSpecification requestSpec = given()
            .baseUri("https://stellarburgers.nomoreparties.site");
    private final String API_LOGIN = "/api/auth/login";
    private final String API_USER = "/api/auth/user";

    private final String API_REGISTER = "/api/auth/register";

    private final Filter requestFilter = new RequestLoggingFilter();
    private final Filter responseFilter = new ResponseLoggingFilter();

    public Response loginUser(User user) {
        return RestAssured.with()
                .filters(requestFilter, responseFilter)
                .header("Content-type", "application/json")
                .spec(requestSpec)
                .body(user)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .post(API_LOGIN);
    }

    public void deleteUser(String accessToken) {

        RestAssured.with()
                .spec(requestSpec)
                .auth().oauth2(accessToken)
                .contentType(ContentType.JSON)
                .delete(API_USER)
                .then()
                .statusCode(HTTP_ACCEPTED);
    }

    public Response createUser(User user) {
        return RestAssured.with()
                .filters(requestFilter, responseFilter)
                .header("Content-type", "application/json")
                .spec(requestSpec)
                .body(user)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .post(API_REGISTER);
    }
}
