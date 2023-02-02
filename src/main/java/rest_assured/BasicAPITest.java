package rest_assured;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicAPITest {
  private static final String CAT_FACT_BASE_URL = "https://catfact.ninja";
  private static final String JSON_PLACEHOLDER_BASE_URL = "https://jsonplaceholder.typicode.com/";
  private static final String SINGLE_FACT_PATH = "/fact";
  private static final String POSTS_PATH = "/posts";

  @BeforeEach
  public void setup() {
    baseURI = CAT_FACT_BASE_URL;
  }

  @Test
  void shouldReturn200() {
    Response response = get(SINGLE_FACT_PATH);
    assertEquals(response.getStatusCode(), 200);
  }

  @Test
  void shouldParseResponseToFact() {
//    when
    Response response = get(SINGLE_FACT_PATH);
    ResponseBody body = response.getBody();
    CatFact catFact = body.as(CatFact.class);

//    then
    assertThat(catFact.getFact(), not(is(emptyOrNullString())));
  }

  @Test
  void shouldParseResponseBodyToListOfPosts() {
//    given
    baseURI = JSON_PLACEHOLDER_BASE_URL;

//    when
    Response response = get(POSTS_PATH);
    ResponseBody body = response.getBody();
    List<Post> posts = body.jsonPath().getList("", Post.class);

//    then
    assertThat(response.statusCode(), is(200));
    assertThat(posts, is(not(empty())));
  }

  @Test
  void shouldReturn200WhenPostNewPost() {
    baseURI = JSON_PLACEHOLDER_BASE_URL;
    Post post = new Post(1, "My test title", "My test body");

    given()
      .contentType("application/json")
      .body(post)
      .when()
      .post(POSTS_PATH)
      .then()
      .assertThat()
      .statusCode(201);
  }
}
