package site.nomoreparties.stellarburgers.servinguser;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ServingUser {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    private static final String DELETE_ENDPOINT = "api/auth/user";
    private static final String LOGIN_ENDPOINT = "api/auth/login";
    private static final String USER_ENDPOINT = "api/auth/register";
    private static final String REGISTER_ENDPOINT = "register";
    private static final String LOGIN_UI_ENDPOINT =  "login";
    private static final String RECOVERY_ENDPOINT = "forgot-password";
    private static final String ACCOUNT_ENDPOINT = "account/profile";


    public String getBaseUrl() {
        return BASE_URL;
    }

    public String getUserRegister() {

        return BASE_URL + REGISTER_ENDPOINT;
    }

    public String getUserLoginUI() {

        return BASE_URL + LOGIN_UI_ENDPOINT;
    }

    public Response CreateUser(CreateUser createuser) {
        return given()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(createuser)
                .post(USER_ENDPOINT);
    }

    public Response loginUser(LoginUser loginUser) {
        return given()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(loginUser)
                .post(BASE_URL + LOGIN_ENDPOINT);
    }

    public Response deleteUser(String accessToken) {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .header("Authorization", accessToken)
                .when()
                .delete(BASE_URL + DELETE_ENDPOINT);
    }

    public String getRecovery() {
        return BASE_URL + RECOVERY_ENDPOINT;
    }

    public String getAccountProfile() {
        return BASE_URL + ACCOUNT_ENDPOINT;
    }
}
