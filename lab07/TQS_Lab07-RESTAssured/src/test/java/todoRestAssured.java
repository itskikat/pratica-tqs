import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class todoRestAssured {

    @DisplayName("the endpoint to list all ToDo is available (status code 200)")
    @Test
    public void givenURL_whenSuccessOnGet_thenCorrect() {
        given()
        .when()
                .get("https://jsonplaceholder.typicode.com/todos")
        .then()
                .assertThat()
                .statusCode(200);
    }


    @DisplayName("the title of ToDo #4 is “et porro tempora”")
    @Test
    public void givenURL_whenSuccessOnGetSpecificTodoAndHasRequiredTitle_thenCorrect() {
        String title = "et porro tempora";

        given()
        .when()
                .get("https://jsonplaceholder.typicode.com/todos/4")
        .then()
                .assertThat()
                .statusCode(200)
                .and()
                    .body("title", equalTo(title))
                .and()
                    .body("id", equalTo(4))
                .and()
                    .body("completed", equalTo(true));

    }


    @DisplayName("When listing all “todos”, you get id #198 and #199 in the results.")
    @Test
    public void givenURL_whenSuccessOnGetHasRequiredIds_thenCorrect() {
        given()
        .when()
                .get("https://jsonplaceholder.typicode.com/todos")
        .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("id", hasItems(198, 199));
    }



}
