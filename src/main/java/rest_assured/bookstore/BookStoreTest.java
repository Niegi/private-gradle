package rest_assured.bookstore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static rest_assured.bookstore.BookStoreEndpoints.AUTHORIZED;

public class BookStoreTest {

  @BeforeEach
  public void setup() {
    baseURI = "https://demoqa.com/";
  }

  @Test
  void notExistingUserAuthorizationShouldReturn404() {
    String body = "{\n" +
      "  \"userName\": \"admin\",\n" +
      "  \"password\": \"admin\"\n" +
      "}";

    given()
      .contentType("application/json")
      .body(body)
      .when()
      .post(AUTHORIZED.getValue())
      .then()
      .statusCode(404);
  }
}
