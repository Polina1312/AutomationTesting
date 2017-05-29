package restAssureTest;

import com.jayway.restassured.http.ContentType;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Polina_Panarina on 5/25/2017.
 */

public class PositiveTests {

    @Test
    public void getCurrentWeatherFromCity() {
        given().when().get("http://api.apixu.com/v1/current.json?key=239cb3791fbb4487a3c152609172405&q=Kharkiv")
                .then().body("location.name", equalTo("Kharkiv"));
    }

    @Test
    public void getForecastWeatherByCityForSomeDays() {
        given().when().get("http://api.apixu.com/v1/forecast.json?key=239cb3791fbb4487a3c152609172405&q=Kharkiv&days=5")
                .then()
                .contentType(ContentType.JSON).
                body("forecast.forecastday.size()", is(5));
    }

    @Test
    public void getMaxTemperature() {
        given().when().get("http://api.apixu.com/v1/forecast.json?key=239cb3791fbb4487a3c152609172405&q=Kharkiv")
                .then()
                .body("forecast.forecastday.get(0).day.maxtemp_c.toString()", equalTo("18.2"));
    }

    @Test
    public void getMinTemperature() {
        given().when().get("http://api.apixu.com/v1/forecast.json?key=239cb3791fbb4487a3c152609172405&q=Kharkiv")
                .then()
                .body("forecast.forecastday.get(0).day.mintemp_c.toString()", equalTo("8.2"));
    }

    @Test
    public void getForecastWeatherByCityWithDateTime() {
        given().when().get("http://api.apixu.com/v1/forecast.json?key=239cb3791fbb4487a3c152609172405&dt=2017-05-27&q=Kharkiv&hour=5")
                .then()
                .body("location.name", equalTo("Kharkiv"))
                .body("forecast.forecastday.get(0).hour.get(0).time.toString()", equalTo("2017-05-27 05:00"));
    }

}
