package restAssureTest;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Polina_Panarina on 5/26/2017.
 */
public class NegativeTests {

    @Test
    public void inputInvalidTown() {
        given().when().get("http://api.apixu.com/v1/current.json?key=239cb3791fbb4487a3c152609172405&q=TestCity")
                .then()
                .body("error.code.toString()", equalTo("1006"));
    }

    @Test
    public void inputInvalidKey() {
        given().when().get("http://api.apixu.com/v1/current.json?key=TestKey&q=Kharkiv")
                .then()
                .body("error.code.toString()", equalTo("2006"));
    }

    @Test
    public void inputInvalidUrl() {
        given().when().get("http://api.apixu.com/v1/currentTEST.json?key=key=239cb3791fbb4487a3c152609172405&q=Kharkiv")
                .then()
                .body("error.code.toString()", equalTo("1005"));
    }

    @Test
    public void inputInvalidUrlDate() {
        given().when().get("http://api.apixu.com/v1/forecast.json?key=239cb3791fbb4487a3c152609172405&dt=2017-25-25&q=Kharkiv")
                .then()
                .body("error.code.toString()", equalTo("1007"));
    }

    @Test
    public void tryToExecuteQueryWithoutKey() {
        given().when().get("http://api.apixu.com/v1/forecast.json?q=Paris")
                .then()
                .body("error.code.toString()", equalTo("1002"));
    }

}
