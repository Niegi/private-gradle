package rest_assured.jwt_auth;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DemoQAJwtTest {

  private static final String USERNAME = "my_test_user";
  private static final String PASSWORD = "myTestUser1!";

  //  endpoints
  private static final String BASE_URI = "https://demoqa.com";
  private static final String USER_ENDPOINT = "/Account/v1/User";
  private static final String AUTHORIZED_ENDPOINT = "/Account/v1/Authorized";
  private static final String GENERATE_TOKEN_ENDPOINT = "/Account/v1/GenerateToken";

  private String body;
  private String userID;
  private String token;

  @BeforeAll
  private void setup() {
    baseURI = BASE_URI;
    body = "{\n" +
      "  \"userName\": \"" + USERNAME + "\",\n" +
      "  \"password\": \"" + PASSWORD + "\"\n" +
      "}";
    createUser();
    generateToken();
  }

  @AfterAll
  private void cleanUp() {
    deleteUser();
  }

  @Test
  void getAuthorizedUser() {
    given()
      .contentType("application/json")
      .headers("Authorization", "Bearer " + token)
      .when()
      .get(USER_ENDPOINT + "/" + userID)
      .then()
      .assertThat()
      .statusCode(HttpStatus.SC_OK);
  }

  @Test
  void getUnauthorizedUser() {
    given()
      .contentType("application/json")
      .when()
      .get(USER_ENDPOINT + "/" + userID)
      .then()
      .assertThat()
      .statusCode(HttpStatus.SC_UNAUTHORIZED);
  }

  private void createUser() {
    userID = given()
      .contentType("application/json")
      .body(body)
      .when()
      .post(USER_ENDPOINT)
      .jsonPath()
      .get("userID");
  }

  private void generateToken() {
    token = given()
      .contentType("application/json")
      .body(body)
      .when()
      .post(GENERATE_TOKEN_ENDPOINT)
      .jsonPath()
      .get("token");
  }

  private void deleteUser() {
    given()
      .contentType("application/json")
      .headers("Authorization", "Bearer " + token)
      .when()
      .delete(USER_ENDPOINT + "/" + userID);
  }
}
